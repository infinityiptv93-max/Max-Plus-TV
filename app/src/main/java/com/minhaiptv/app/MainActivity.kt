package com.minhaiptv.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF101010)
private val SurfaceDark = Color(0xFF1D1D1D)
private val AccentRed = Color(0xFFE53935)
private val TextWhite = Color(0xFFF5F5F5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaxPlusTVApp() }
    }
}

@Composable
fun MaxPlusTVApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    MaterialTheme {
        Scaffold(
            containerColor = Background,
            bottomBar = {
                NavigationBar(containerColor = SurfaceDark, contentColor = TextWhite) {
                    NavigationBarItem(selected = selectedTab == 0, onClick = { selectedTab = 0 }, icon = { Icon(Icons.Default.Home, contentDescription = "Início") }, label = { Text("Início") })
                    NavigationBarItem(selected = selectedTab == 1, onClick = { selectedTab = 1 }, icon = { Icon(Icons.Default.LiveTv, contentDescription = "Ao vivo") }, label = { Text("Ao vivo") })
                    NavigationBarItem(selected = selectedTab == 2, onClick = { selectedTab = 2 }, icon = { Icon(Icons.Default.Movie, contentDescription = "Filmes") }, label = { Text("Filmes") })
                    NavigationBarItem(selected = selectedTab == 3, onClick = { selectedTab = 3 }, icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") }, label = { Text("Buscar") })
                }
            }
        ) { padding ->
            Column(Modifier.fillMaxSize().padding(padding).background(Background).padding(18.dp)) {
                Text("MAX PLUS TV", color = AccentRed, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                Text("Seu entretenimento em um só lugar", color = Color.LightGray, fontSize = 13.sp)
                Spacer(Modifier.height(24.dp))
                Card(colors = CardDefaults.cardColors(containerColor = SurfaceDark), shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(18.dp)) {
                        Text("BEM-VINDO", color = Color.LightGray, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        Text("Uma nova experiência de entretenimento", color = TextWhite, fontSize = 21.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(14.dp))
                        Button(onClick = { selectedTab = 1 }, colors = ButtonDefaults.buttonColors(containerColor = AccentRed)) {
                            Text("Explorar conteúdo autorizado", color = Color.White)
                        }
                    }
                }
                Spacer(Modifier.height(24.dp))
                Text(if (selectedTab == 1) "Canais ao vivo" else if (selectedTab == 2) "Filmes e séries" else if (selectedTab == 3) "Buscar conteúdo" else "Explore por categoria", color = TextWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(12.dp))
                val categories = listOf("Ao vivo", "Filmes", "Séries", "Favoritos")
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(categories) { category ->
                        Surface(color = SurfaceDark, shape = RoundedCornerShape(12.dp)) {
                            Text(category, color = TextWhite, modifier = Modifier.padding(horizontal = 18.dp, vertical = 14.dp))
                        }
                    }
                }
                Spacer(Modifier.height(22.dp))
                Card(colors = CardDefaults.cardColors(containerColor = SurfaceDark), shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text("Próximo passo", color = TextWhite, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(5.dp))
                            Text("Conectar uma fonte de conteúdo licenciada será configurado em uma etapa futura.", color = Color.LightGray, fontSize = 13.sp)
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
                Text("Versão inicial • Interface demonstrativa", color = Color.Gray, fontSize = 11.sp)
            }
        }
    }
}
