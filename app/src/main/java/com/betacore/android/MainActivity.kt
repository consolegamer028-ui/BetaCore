package com.betacore.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bg = Color(0xFF0B0D12)
private val Panel = Color(0xFF151922)
private val PanelRaised = Color(0xFF202735)
private val Mint = Color(0xFF83E6B1)
private val Muted = Color(0xFF929BAA)
private val MainText = Color(0xFFF2F5F9)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BetaCoreScreen() }
    }
}

@Composable
private fun BetaCoreScreen() {
    var tab by remember { mutableStateOf("Home") }
    var showImport by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }

    MaterialTheme(colorScheme = darkColorScheme(
        primary = Mint, background = Bg, surface = Panel,
        onBackground = MainText, onSurface = MainText
    )) {
        Scaffold(
            containerColor = Bg,
            bottomBar = {
                NavigationBar(containerColor = Panel) {
                    listOf(
                        Triple("Home", Icons.Default.Dashboard, "Home"),
                        Triple("Console", Icons.Default.Terminal, "Console"),
                        Triple("Worlds", Icons.Default.Public, "Worlds"),
                        Triple("Settings", Icons.Default.Settings, "Settings")
                    ).forEach { (label, icon, key) ->
                        NavigationBarItem(
                            selected = tab == key,
                            onClick = { tab = key; if (key == "Settings") showSettings = true },
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label, fontSize = 11.sp) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Mint, selectedTextColor = Mint,
                                indicatorColor = PanelRaised,
                                unselectedIconColor = Muted, unselectedTextColor = Muted
                            )
                        )
                    }
                }
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            Modifier.size(46.dp).clip(RoundedCornerShape(14.dp))
                                .background(Mint.copy(alpha = .13f))
                                .border(1.dp, Mint.copy(alpha = .3f), RoundedCornerShape(14.dp)),
                            contentAlignment = Alignment.Center
                        ) { Icon(Icons.Default.Hexagon, null, tint = Mint, modifier = Modifier.size(27.dp)) }
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f)) {
                            Text("BETACORE", fontSize = 21.sp, fontWeight = FontWeight.Black, letterSpacing = 2.sp)
                            Text("JAVA BETA SERVER HOST", fontSize = 10.sp, letterSpacing = 1.5.sp, color = Muted)
                        }
                        IconButton(onClick = { showSettings = true }) {
                            Icon(Icons.Default.Tune, "Settings", tint = Muted)
                        }
                    }
                }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text("Your server.", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                        Text("A little piece of old Minecraft, hosted locally.", fontSize = 14.sp, color = Muted)
                    }
                }
                item {
                    Column(
                        Modifier.fillMaxWidth().clip(RoundedCornerShape(22.dp))
                            .background(Panel).border(1.dp, Color(0xFF2B3442), RoundedCornerShape(22.dp))
                            .padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(17.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(Modifier.size(9.dp).clip(CircleShape).background(Color(0xFF697386)))
                            Spacer(Modifier.width(8.dp))
                            Text("SERVER OFFLINE", fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.2.sp, color = Muted)
                            Spacer(Modifier.weight(1f))
                            Surface(color = PanelRaised, shape = RoundedCornerShape(8.dp)) {
                                Text("BETA 1.7", Modifier.padding(horizontal = 10.dp, vertical = 6.dp), color = Mint, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("My Beta World", fontSize = 23.sp, fontWeight = FontWeight.Bold)
                            Text("No server JAR imported yet", fontSize = 13.sp, color = Muted)
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            Button(
                                onClick = { showImport = true },
                                modifier = Modifier.weight(1f).height(48.dp),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Mint, contentColor = Color(0xFF0A1710))
                            ) {
                                Icon(Icons.Default.FileOpen, null, modifier = Modifier.size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Import JAR", fontWeight = FontWeight.Bold)
                            }
                            OutlinedButton(
                                onClick = { tab = "Console" },
                                modifier = Modifier.height(48.dp),
                                shape = RoundedCornerShape(14.dp)
                            ) { Icon(Icons.Default.Terminal, "Console") }
                        }
                    }
                }
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("SERVER OVERVIEW", fontSize = 11.sp, letterSpacing = 1.5.sp, fontWeight = FontWeight.Bold, color = Muted)
                        Spacer(Modifier.weight(1f))
                        Text("THIS DEVICE", fontSize = 10.sp, color = Muted)
                    }
                }
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        MetricCard("JAVA RUNTIME", "Not checked", Icons.Default.Memory, Modifier.weight(1f))
                        MetricCard("WORLD", "Not created", Icons.Default.Landscape, Modifier.weight(1f))
                    }
                }
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        MetricCard("PLAYERS", "—", Icons.Default.Groups, Modifier.weight(1f))
                        MetricCard("PORT", "25565", Icons.Default.Lan, Modifier.weight(1f))
                    }
                }
                item {
                    Column(Modifier.fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(Panel).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Terminal, null, tint = Mint)
                            Spacer(Modifier.width(9.dp))
                            Text("Quick console", fontWeight = FontWeight.Bold)
                            Spacer(Modifier.weight(1f))
                            Text("PREVIEW", fontSize = 9.sp, color = Muted, letterSpacing = 1.sp)
                        }
                        Text("Waiting for server process…", fontSize = 12.sp, color = Muted)
                        Text("Live logs and commands will appear here after server-process integration.", fontSize = 12.sp, color = Muted, lineHeight = 18.sp)
                    }
                }
                item {
                    Text("Independent project. Import your own server JAR. Minecraft is not affiliated with BetaCore.", fontSize = 10.sp, color = Muted, lineHeight = 15.sp)
                }
            }
        }
        if (showImport) AlertDialog(
            onDismissRequest = { showImport = false }, containerColor = Panel,
            title = { Text("Import server JAR") },
            text = { Text("The native file picker and JAR validation are the next milestone. This GUI build does not launch a server yet.", color = Muted) },
            confirmButton = { TextButton(onClick = { showImport = false }) { Text("Got it", color = Mint) } }
        )
        if (showSettings) AlertDialog(
            onDismissRequest = { showSettings = false }, containerColor = Panel,
            title = { Text("BetaCore settings") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                    Text("Appearance: Dark")
                    Text("Target: Minecraft Java Beta 1.7", color = Muted)
                    Text("Server engine: Not connected yet", color = Muted)
                    Text("GUI milestone 0.1", color = Muted)
                }
            },
            confirmButton = { TextButton(onClick = { showSettings = false }) { Text("Close", color = Mint) } }
        )
    }
}

@Composable
private fun MetricCard(title: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, modifier: Modifier = Modifier) {
    Column(
        modifier.clip(RoundedCornerShape(17.dp)).background(Panel).padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(icon, null, tint = Mint, modifier = Modifier.size(20.dp))
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(title, fontSize = 9.sp, letterSpacing = 1.sp, color = Muted, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(value, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}
