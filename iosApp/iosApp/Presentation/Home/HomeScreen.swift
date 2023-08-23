//
//  HomeView.swift
//  iosApp
//
//  Created by Jorge on 29/7/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import KMMViewModelSwiftUI

struct HomeScreen: View {
    
    @ObservedViewModel var viewModel: HomeScreenNewViewModel = ViewModels().getHomeViewModel()
    
    @State private var textFieldInput: String = ""
    
    var body: some View {
        switch viewModel.homeState.loadState {
        
        case LoadState.loaded:
            VStack(spacing: 20) {
                HStack {
                    TextField("Enter Amount", text: $textFieldInput)
                        .padding()
                        .border(Color.gray, width: 1)
                        .keyboardType(.decimalPad)
                    
                    
                    CurrencyPicker(currencies: viewModel.homeState.currencies, onChanged: { baseCurrency in
                        print("Picker Selection \(baseCurrency)")
                        viewModel.onIntent(intent: HomeScreenIntent.BaseCurrencyUpdated(base: baseCurrency))
                    })
                    
                }.onChange(of: textFieldInput) { newAmount in
                    print("New Base: \(newAmount)")
                    if (newAmount.count < 16) {
                        // Remove any non-digit characters and validate the input
                        let digitsOnly = newAmount.filter { $0.isWholeNumber }
                        
                        // Calculate the double value from the sanitized input
                        let convertedValue = Double(digitsOnly) ?? 0.0
                        
                        viewModel.onIntent(intent: HomeScreenIntent.InputAmountUpdated(amount: convertedValue))
                    }
                    
                }
                
                if !textFieldInput.isEmpty {
                    CurrencyGridView(rates: viewModel.homeState.currentRates)
                }
                
            }
            .padding()
        case LoadState.error:
            Text(viewModel.homeState.errorMessage)
        default :
            ProgressView()
        }
        
    }
}


struct CurrencyPicker: View {
    var currencies: [Currency]
    var onChanged: (String) -> Void
    
    @State private var selectedIndex = 0
    
    var body: some View {
        if !currencies.isEmpty {
            Picker("Select a currency", selection: $selectedIndex) {
                ForEach(0..<currencies.count, id: \.self) { index in
                    Text(currencies[index].code).tag(index)
                }
            }
            .pickerStyle(MenuPickerStyle())
            .padding()
            .border(Color.gray, width: 1)
            .onAppear {
                self.onChanged(currencies[0].code)
            }
            .onChange(of: selectedIndex, perform: {
                index in self.onChanged(currencies[index].code)
            })
        }
    }
}

struct CurrencyCardView: View {
    let amount: String
    
    var body: some View {
        VStack {
            Text(amount)
                .font(.headline)
                .padding()
            
        }
        .frame(width: .infinity)
        .cornerRadius(10)
        .padding()
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(Color.black, lineWidth: 1)
        )
    }
}

struct CurrencyGridView : View {
    let rates: [RateDisplay]
    
    var body: some View {
        ScrollView {
            LazyVGrid(columns: Array(repeating: GridItem(.fixed(150), spacing: 10), count: 2), spacing: 20) {
                ForEach(rates, id: \.self) { rate in
                    CurrencyCardView(amount: rate.amount)
                        .frame(maxWidth: .infinity, maxHeight: .infinity)
                }
            }
            .padding()
        }.frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
