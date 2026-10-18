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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
        composable("Listasdedatos") { Listasdedatos(navController, modifier) }
        composable("FormularioComprador") { FormularioComprador(navController, modifier) }
        composable("FormularioVendedor") { FormularioVendedor(navController, modifier) }
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
                if (usuario.isBlank() || contrasena.isBlank()) {
                    Toast.makeText(context, "Ingresa usuario y contraseña", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Bienvenido ${usuario}", Toast.LENGTH_SHORT).show()
                    navController.navigate("MenuContent") {
                        popUpTo("LoginContent") { inclusive = true }
                    }
                }
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
                navController.navigate("FormularioComprador")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "formulario de compradores",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("Listasdedatos")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "agencia de carros datos",
                style = TextStyle(textDecoration = TextDecoration.Underline),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("FormularioVendedor")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Formulario de vendedores",
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

    val marcas = listOf(
        Opcion("0", "Selecciona una marca"),
        Opcion("1", "Ford"),
        Opcion("2", "Nissan"),
        Opcion("3", "Volkswagen"),
        Opcion("4", "Chevrolet"),
        Opcion("5", "Toyota"),
        Opcion("6", "BMW")
    )
    var marcaExpandida by remember { mutableStateOf(false) }
    var marca by remember { mutableStateOf(marcas[0]) }

    var modelo: String by remember { mutableStateOf("") }
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


        Text(text = "Marca:")
        ExposedDropdownMenuBox(
            expanded = marcaExpandida,
            onExpandedChange = { marcaExpandida = !marcaExpandida }
        ) {
            TextField(
                value = marca.label,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = marcaExpandida)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = marcaExpandida,
                onDismissRequest = { marcaExpandida = false }
            ) {
                marcas.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion.label) },
                        onClick = {
                            marca = opcion
                            marcaExpandida = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Modelo:")
        TextField(
            value = modelo,
            onValueChange = { modelo = it },
            placeholder = { Text("Ingresa el Modelo") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "precio del Vehiculo:")
        TextField(
            value = precio,
            onValueChange = { precio = it },
            placeholder = { Text("Ingresa el precio") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                Toast.makeText(context, "id marca: ${marca.value}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "marca: ${marca.label}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "modelo: ${modelo}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "precio: ${precio}", Toast.LENGTH_SHORT).show()

            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar")
        }

        Button(
            onClick = {
                modelo = ""
                precio = ""
                marca = marcas[0]

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

//andres cardenas - se agrego el formulario compradores
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioComprador(navController: NavController,modifier: Modifier = Modifier) {
    val context = LocalContext.current




    var Nombre: String by remember { mutableStateOf("") }
    var precio: String by remember { mutableStateOf("") }
    var Telefono: String by remember { mutableStateOf("") }
    var Correo: String by remember { mutableStateOf("") }

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



        Text(text = "Nombre del comprador:")
        TextField(
            value = Nombre,
            onValueChange = { Nombre = it },
            placeholder = { Text("Ingresa el Nombre del comprador") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "precio del Vehiculo:")
        TextField(
            value = precio,
            onValueChange = { precio = it },
            placeholder = { Text("Ingresa el precio") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Telefono:")
        TextField(
            value = Telefono,
            onValueChange = { Telefono = it },
            placeholder = { Text("Ingrese el telefono del comprador") },
            modifier = Modifier.fillMaxWidth(),

        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Correo:")
        TextField(
            value = Correo,
            onValueChange = { Correo = it },
            placeholder = { Text("Ingrese el correo del comprador") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                Toast.makeText(context, "Nombrecomprador : ${Nombre}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Telefono: ${Telefono}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "precio: ${precio}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Correo: ${Correo}", Toast.LENGTH_SHORT).show()


            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar")
        }

        Button(
            onClick = {
                Nombre = ""
                precio = ""
                Correo = ""
                Telefono = ""

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

//se agrego el formulario de finanzas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulariofinanzas(navController: NavController,modifier: Modifier = Modifier) {
    val context = LocalContext.current




    var gananciasmensuales: String by remember { mutableStateOf("") }
    var fecha: String by remember { mutableStateOf("") }
    var numero_ventas: String by remember { mutableStateOf("") }

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



        Text(text = "Ganancias Mensuales:")
        TextField(
            value = gananciasmensuales,
            onValueChange = { gananciasmensuales = it },
            placeholder = { Text("Ingresa las ganancias mensuales") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "fecha")
        TextField(
            value = fecha,
            onValueChange = { fecha = it },
            placeholder = { Text("Ingresa la fecha") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "numero de ventas:")
        TextField(
            value = numero_ventas,
            onValueChange = { numero_ventas = it },
            placeholder = { Text("Ingrese el numero de ventas") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))



        Button(
            onClick = {

                Toast.makeText(context, "gananciasmensuales : ${gananciasmensuales}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "fecha: ${fecha}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "numero_ventas: ${numero_ventas}", Toast.LENGTH_SHORT).show()



            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar")
        }

        Button(
            onClick = {
                gananciasmensuales = ""
                fecha = ""
                numero_ventas = ""


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





//se agrego la tabla de carros - josse juan talamantes
//se agrego la tabla de vendedores - victor nicolas
// se agrego la tabla de compradores - victor nicolas
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioVendedor(navController: NavController,modifier: Modifier = Modifier) {
    val context = LocalContext.current




    var Nombre: String by remember { mutableStateOf("") }
    var Ventas: String by remember { mutableStateOf("") }
    var FechaVenta: String by remember { mutableStateOf("") }
    var Usuario: String by remember { mutableStateOf("") }
    var Contrasena: String by remember { mutableStateOf("") }

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



        Text(text = "Nombre del vendedor:")
        TextField(
            value = Nombre,
            onValueChange = { Nombre = it },
            placeholder = { Text("Ingresa el Nombre del vendedor") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Ventas:")
        TextField(
            value = Ventas,
            onValueChange = { Ventas = it },
            placeholder = { Text("Ingresa tus ventas") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Fecha de la venta:")
        TextField(
            value = FechaVenta,
            onValueChange = { FechaVenta = it },
            placeholder = { Text("Ingrese la fecha de la venta") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Usuario:")
        TextField(
            value = Usuario,
            onValueChange = { Usuario = it },
            placeholder = { Text("Ingrese el usuario") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Contraseña:")
        TextField(
            value = Contrasena,
            onValueChange = { Contrasena = it },
            placeholder = { Text("Ingrese la contraseña") },
            modifier = Modifier.fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                Toast.makeText(context, "NombreVendero : ${Nombre}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Ventas: ${Ventas}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "FechaVenta: ${FechaVenta}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Usuario: ${Usuario}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Contrasena: ${Contrasena}", Toast.LENGTH_SHORT).show()


            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Enviar")
        }

        Button(
            onClick = {
                Nombre = ""
                Ventas = ""
                FechaVenta = ""
                Usuario = ""
                Contrasena = ""

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
fun Listasdedatos(navController: NavController,modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val scrollStateVertical = rememberScrollState()

    data class Vendedor(val idvendedor: Int,
                        val idsucursal: Int,
                        val nombre: String,
                        val ventas: String,
                        val fechaventa: String,
                        val usuario: String,
                        val contrasena: String)

    data class Comprador(val idcomprador: Int,
                         val nombre: String,
                         val costo: String,
                         val telefono: String,
                         val correo: String)

    data class Carro(val idcarro: Int,
                        val idsucursal: Int,
                        val nombreservicio: String,
                        val marca: String,
                        val modelo: String,
                        val motor: String,)

    val vendedores = remember {
        mutableStateListOf(

            Vendedor(idvendedor = 1, idsucursal = 1, nombre= "pepe", ventas = "12", fechaventa = "26 oct 2026", usuario = "pepe01", contrasena = "12345"),
            Vendedor(idvendedor = 2, idsucursal = 1, nombre= "juan", ventas = "22", fechaventa = "12 sep 2026", usuario = "juan02", contrasena = "12345"),
        )
    }



    val compradores = remember {
        mutableStateListOf(

            Comprador(idcomprador = 1,  nombre= "pepe", costo = "12", telefono = "8783671865", correo = "pepe@gmail.com"),
            Comprador(idcomprador = 2, nombre= "juan", costo = "22", telefono = "87856749299", correo = "juan@gmail.com"),
        )
    }

                      val carros = remember {
                          mutableStateListOf(

                              Carro(idcarro = 1,  idsucursal= 1 , nombreservicio = "Cambio de aceite", marca = "Chevrolet", modelo = "camaroSS", motor = "V8 6.2L"),
                              Carro(idcarro = 2,  idsucursal= 1 , nombreservicio = "Cambio de camara ", marca = "Toyota", modelo = "Tundra", motor = "V8 4.7L"),
                          )
                      }




    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollStateVertical)
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
            Text("IdComprador", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Nombre", modifier = Modifier.width(150.dp), fontWeight = FontWeight.Bold)
            Text("costo", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("telefono", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("correo", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)


        }
        Divider()
        compradores.forEachIndexed { index, comprador ->
            val bgColor = if (index % 2 == 0) Color(0xFFF5F5F5) else Color.White

            Row (
                modifier = Modifier
                    .background(bgColor)
            ) {
                Text(" ${comprador.idcomprador}", modifier = Modifier
                    .width(100.dp)
                )

                Text(comprador.nombre, modifier = Modifier
                    .width(150.dp)
                )
                Text(comprador.costo, modifier = Modifier
                    .width(150.dp)
                )
                Text(comprador.telefono, modifier = Modifier
                    .width(150.dp)
                )
                Text(comprador.correo, modifier = Modifier
                    .width(150.dp)
                )


                Button(onClick = {
                    compradores.removeAt(index)


                }) {
                    Text("Eliminar")
                }


            }
        }

        Text(
        text= "carros",
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row {
            Text("IdCarro", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Idsucursal", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Nombreservicio", modifier = Modifier.width(150.dp), fontWeight = FontWeight.Bold)
            Text("Marca", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Modelo", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)
            Text("Motor", modifier = Modifier.width(100.dp), fontWeight = FontWeight.Bold)

        }
        Divider()
        carros.forEachIndexed { index, Carro ->
            val bgColor = if (index % 2 == 0) Color(0xFFF5F5F5) else Color.White

            Row (
                modifier = Modifier
                    .background(bgColor)
            ) {
                Text(" ${Carro.idcarro}", modifier = Modifier
                    .width(100.dp)
                )
                Text(" ${Carro.idsucursal}", modifier = Modifier
                    .width(100.dp)
                )
                Text(Carro.nombreservicio, modifier = Modifier
                    .width(150.dp)
                )
                Text(Carro.marca, modifier = Modifier
                    .width(150.dp)
                )
                Text(Carro.modelo, modifier = Modifier
                    .width(150.dp)
                )
                Text(Carro.motor, modifier = Modifier
                    .width(150.dp)
                )

                Button(onClick = {
                    carros.removeAt(index)


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