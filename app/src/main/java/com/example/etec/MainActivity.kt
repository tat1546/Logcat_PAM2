package com.example.etec
//Tatiane
import android.os.Bundle

import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.etec.ui.theme.NotaBButtonColors
import com.example.etec.ui.theme.NotaIButtonColors
import com.example.etec.ui.theme.NotaMBButtonColors
import com.example.etec.ui.theme.NotaRButtonColors

import com.example.etec.ui.theme.EtecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtecTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                    cadastro()
                }
            }
        }
    }
}

@Composable
fun cadastro(){
    var nome by remember { mutableStateOf("") }

    Column(Modifier
        .fillMaxWidth(),
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(text = "Atividade de PAM 2 - Logcat",
                fontSize = 15.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo_etec),
                contentDescription = "Etec ZL"
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
        )

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = nome,
                onValueChange = {novoValor -> nome = novoValor},
                label = { Text("Digite seu nome: ")}

            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
@Composable
@Preview(showBackground = true)
fun cadastroPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Image(
                painter = painterResource(R.drawable.eteclogo),
                contentDescription = "Etec ZL"
            )
        }
        cadastro()
    }
}


@Composable
private fun App(){
    Surface (
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(150.dp))

            ActionButton(
                text = "Menção I",
                buttonColors = NotaIButtonColors(),
                modifier = Modifier.fillMaxWidth(0.9f)
            ){
                /* Ação no Botão */
                Log.e(TAG, "App:Você Clicou na menção I")
            }
            ActionButton(
                text = "Menção R",
                buttonColors = NotaRButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /* Ação no Botão */
                Log.w(TAG, "App:Você Clicou na menção R")
            }
            ActionButton(
                text = "Menção B",
                buttonColors = NotaBButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /* Ação no Botão */
                Log.i(TAG, "Você Clicou na menção B")
            }
            ActionButton(
                text = "Menção MB",
                buttonColors = NotaMBButtonColors(),
                modifier = Modifier.fillMaxWidth()
            ) {
                try {
                    throw RuntimeException("App: Clicou na nota MB - Parabéns")
                }catch(ex: Exception){
                    Log.d(TAG, "Você Clicou na menção MB - Parabéns")
                }
            }
        }
    }
}
@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = Modifier
    )
    {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EtecTheme {
        Greeting("Android")
    }
}