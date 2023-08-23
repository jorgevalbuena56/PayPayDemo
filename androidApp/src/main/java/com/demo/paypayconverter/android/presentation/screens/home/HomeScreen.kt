package com.demo.paypayconverter.android.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.demo.paypayconverter.android.compose.CurrencyTextField
import com.demo.paypayconverter.domain.model.Currency
import com.demo.paypayconverter.presentation.home.HomeScreenIntent
import com.demo.paypayconverter.presentation.home.HomeScreenNewViewModel
import com.demo.paypayconverter.presentation.home.LoadState
import com.demo.paypayconverter.presentation.model.RateDisplay

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(viewModel: HomeScreenNewViewModel) {
    val scaffoldState = rememberScaffoldState()

    val state by viewModel.homeState.collectAsState()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Currency Converter") },
                elevation = 4.dp
            )
        },
        content = { pValues ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    when(state.loadState) {
                        LoadState.LOADING -> {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                        LoadState.LOADED -> {
                            if (state.currencies.isNotEmpty()) {
                                CurrencyTextField(
                                    value = viewModel.amountFormatted(),
                                    onValueChange = { newValue: Double ->
                                        viewModel.onIntent(HomeScreenIntent.InputAmountUpdated(newValue))
                                    }
                                )
                                CurrencyDropdownMenuBox(baseCurrency = state.base, currencyList = state.currencies) { code ->
                                    viewModel.onIntent(HomeScreenIntent.BaseCurrencyUpdated(code))
                                }
                            }
                        }
                        LoadState.ERROR -> {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(text = state.errorMessage)
                            }

                        }
                        LoadState.IDLE -> {

                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                if (state.currentRates.isNotEmpty() && state.amount > 0.0) {
                    CurrenciesConversionGrid(state.currentRates)
                }
            }
        }
    )
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CurrencyDropdownMenuBox(baseCurrency: String, currencyList: List<Currency>, onCurrencySelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(baseCurrency) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                currencyList.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            selectedText = item.code
                            expanded = false
                            onCurrencySelected(item.code)
                        }
                    ) {
                        Text(text = item.code, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun CurrenciesConversionGrid(rates: List<RateDisplay>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(rates.size) { index ->
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = rates[index].amount)
                }
            }
        }
    }
}