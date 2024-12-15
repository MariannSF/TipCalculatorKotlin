package com.example.tipcalculatork
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculatork.ui.theme.TipCalculatorKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorKTheme {
                TipCalculatorApp()
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Header Section with title
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Cyan)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Tip Calculator",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
            }

            //Spacer(modifier = Modifier.height(16.dp))

            // Body Section
            BodyOfApp()
        }
    }


@Composable
private fun BodyOfApp() {

    val billAmount = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(2
            .dp)
    ) {
        // Bill input
        BillInput(billAmount = billAmount)

        // Tip % (placeholder)
        TipPercent()

        // Custom Tip %
        CustomTip()

        // Tip display
        TipDisplay()

        // Total display (placeholder)
        TotalDisplay()

        // Split by (placeholder)
        SplitBy()

        //Total/Person
        TotalPerson()

        // Clear button (placeholder)
        ClearButton()
    }
}


@Composable
fun BillInput(billAmount: MutableState<String>) {
    OutlinedTextField(
        value = billAmount.value,
        onValueChange = { input -> billAmount.value = input },
        label = { Text("Enter Bill Total") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TipPercent() {
    val context = LocalContext.current // Get the current context
    val options = listOf("10%", "15%", "18%", "Custom")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Tip %:",
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(end = 8.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (option == selectedOption),
                            onClick = {
                                selectedOption = option
                            },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = {
                            selectedOption = option
                            Toast.makeText(context, "Selected: $option", Toast.LENGTH_SHORT).show()
                        }
                    )
                    Text(
                        text = option,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun CustomTip() {
    // Placeholder implementation for Split Option
    Text("Custom Tip (To be implemented)")
}

@Composable
fun TipDisplay() {
    // Placeholder implementation for Split Option
    Text("Tip display (To be implemented)")
}

@Composable
fun TotalDisplay() {
    // Placeholder implementation for Total Display
    Text("Total Amount (To be implemented)")
}

@Composable
fun SplitBy() {
    // Placeholder implementation for Split Option
    Text("Split By (To be implemented)")
}
@Composable
fun TotalPerson() {
    // Placeholder implementation for Split Option
    Text("Total/ Person (To be implemented)")
}


@Composable
fun ClearButton() {
    // Placeholder implementation for Clear Button
    Button(
        onClick = { /* Clear functionality to be implemented */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Clear")
    }
}

@Preview(showBackground = true)
@Composable
fun TipCalculatorPreview() {
    TipCalculatorKTheme {
        TipCalculatorApp()
    }
}
