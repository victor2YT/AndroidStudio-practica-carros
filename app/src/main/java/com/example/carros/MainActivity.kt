package com.example.carros

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carros.ui.theme.CarrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarrosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable

fun AppContent(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "LoginContent") {
        composable("LoginContent") { LoginContent(navController, modifier) }
        composable("MenuContent") { MenuContent(navController, modifier) }
        composable("FormularioCarrosContent") { FormularioCarrosContent(navController, modifier) }
        composable("ListasProductosContent") { ListasProductosContent(navController, modifier) }
    }
}

@Composable
fun LoginContent(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var usuario: String by remember { mutableStateOf("") }
    var contrasena: String by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Button(
            onClick = {
                navController.navigate("MenuContent")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "menu",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Inicio de Sesión en Vajacars",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(text = "Usuario:")
        TextField(
            value = usuario,
            onValueChange = { usuario = it },
            placeholder = { Text("Ingresa tu usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Contraseña:")
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            placeholder = { Text("Ingresa tu contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = {
                Toast.makeText(context, "Usuario: ${usuario}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Contraseña: ${contrasena}", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Iniciar sesión")
        }
    }

}








@Composable
fun MenuContent(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text= "menu",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("LoginContent")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "inicio de sesion",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("FormularioCarrosContent")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "formulario de Carros",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("ListasProductosContent")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "listas de productos",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioCarrosContent(navController: NavController,modifier: Modifier = Modifier) {
    val context = LocalContext.current

    data class Opcion(val value: String, val label: String)

    val proveedores = listOf(
        Opcion("0", "selecciona una opccion"),
        Opcion("1", "chevrolet"),
        Opcion("2", "ford"),
        Opcion("3", "nissan"),
        Opcion("4", "toyota")




    )
    var proveedorExpandido by remember { mutableStateOf(false) }
    var proveedor by remember { mutableStateOf(proveedores[0]) }





    var nombrevideojuego: String by remember { mutableStateOf("") }
    var precio: String by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {


        // Aquí irán nuestras cajas de texto y botones.
        Button(
            onClick = {
                navController.navigate("MenuContent")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "menu",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))



        Text(text = "Nombre del videojuego:")
        TextField(
            value = nombrevideojuego,
            onValueChange = { nombrevideojuego = it },
            placeholder = { Text("Ingresa tu nombre del videojuego") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Precio del Videojuego:")
        TextField(
            value = precio,
            onValueChange = { precio = it },
            placeholder = { Text("Ingresa el precio") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Modelo:")
        ExposedDropdownMenuBox(
            expanded = proveedorExpandido,
            onExpandedChange = { proveedorExpandido = !proveedorExpandido }
        ) {
            TextField(
                value = proveedor.label,
                onValueChange = {},
                readOnly = true,
                label = { Text("Selecciona una opción") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = proveedorExpandido)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            DropdownMenu(
                expanded = proveedorExpandido,
                onDismissRequest = { proveedorExpandido = false }
            ) {
                proveedores.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion.label) },
                        onClick = {
                            proveedor = opcion
                            proveedorExpandido = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                Toast.makeText(context, "Nombre del videojuego: ${nombrevideojuego}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Precio: ${precio}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Id Proveedor: ${proveedor.value}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Nombre del Proveedor: ${proveedor.label}", Toast.LENGTH_SHORT).show()

            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar")
        }

        Button(
            onClick = {
                nombrevideojuego = "FORTNITE"
                precio = ""
                proveedor = proveedores[0]

                Toast.makeText(
                    context,
                    "Formulario limpiado",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.align(Alignment.End)

        ) {
            Text("Limpiar")
        }






    }
}












@Composable
fun ListasProductosContent(navController: NavController,modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    data class Trabajador(val id: Int, val nombre: String, val trabajo: String, val clave: String)
    val trabajadores = remember {
        mutableStateListOf(

            Trabajador(id = 1,nombre= "pepe",trabajo = "programacion", clave= "12345"),
            Trabajador(id = 2,nombre= "juan",trabajo = "diseñador", clave= "12345"),
        )
    }
    // productos[index] = Producto(nombre, precio, existencias)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .horizontalScroll(scrollState),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Aquí irán nuestras cajas de texto y botones.

        Button(
            onClick = {
                navController.navigate("MenuContent")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "menu",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text= "vendedores",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row {
            Text("IdVendedor", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Idsucursal", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Nombre", modifier = Modifier.width(150.dp), fontWeight = FontWeight.Bold)
            Text("ventas", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("FechaVenta", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("usuario", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("contrasena", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)

        }
        Divider()
        vendedores.forEachIndexed { index, vendedor ->
            val bgColor = if (index % 2 == 0) Color(0xFFF5F5F5) else Color.White

            Row (
                modifier = Modifier
                    .background(bgColor)
            ) {
                Text(" ${vendedor.idvendedor}", modifier = Modifier
                    .width(100.dp)
                )
                Text(" ${vendedor.idsucursal}", modifier = Modifier
                    .width(100.dp)
                )
                Text(vendedor.nombre, modifier = Modifier
                    .width(150.dp)
                )
                Text(vendedor.ventas, modifier = Modifier
                    .width(150.dp)
                )
                Text(vendedor.fechaventa, modifier = Modifier
                    .width(150.dp)
                )
                Text(vendedor.usuario, modifier = Modifier
                    .width(150.dp)
                )
                Text(vendedor.contrasena, modifier = Modifier
                    .width(150.dp)
                )

                Button(onClick = {
                    vendedores.removeAt(index)


                }) {
                    Text("Eliminar")
                }


            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text= "compradores",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row {
            Text("Id", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Nombre", modifier = Modifier.width(150.dp), fontWeight = FontWeight.Bold)
            Text("trabajo", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("clave", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)

        }
        Divider()
        trabajadores.forEachIndexed { index, trabajador ->
            val bgColor = if (index % 2 == 0) Color(0xFFF5F5F5) else Color.White

            Row (
                modifier = Modifier
                    .background(bgColor)
            ) {
                Text("$ ${trabajador.id}", modifier = Modifier
                    .width(100.dp)
                )
                Text(trabajador.nombre, modifier = Modifier
                    .width(150.dp)
                )
                Text(trabajador.trabajo, modifier = Modifier
                    .width(150.dp)
                )
                Text(trabajador.clave, modifier = Modifier
                    .width(150.dp)
                )

                Button(onClick = {
                    trabajadores.removeAt(index-1)


                }) {
                    Text("Eliminar")
                }


            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun ListasProductosPreview() {
    CarrosTheme {
        FormularioCarrosContent(
            navController = rememberNavController()
        )
    }
}