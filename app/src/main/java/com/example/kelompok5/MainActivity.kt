package com.example.kelompok5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Warna yang dipakai bersama di semua halaman
object WarnaApp {
    val BiruTua = Color(0xFF1E3A8A)
    val BiruUtama = Color(0xFF2563EB)
    val BiruKartu = Color(0xFF1E64C8)
    val BiruMuda = Color(0xFFDBEAFE)
    val BiruLabel = Color(0xFF93C5FD)
}

// Nama rute navigasi (dipusatkan supaya tidak salah ketik)
object Rute {
    const val LOBBY = "lobby"
    const val MENU = "menu"
    const val DETAIL = "detail"
    const val ARG_NAMA = "namaAnggota"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Rute.LOBBY) {

                // Lobby -> Menu
                composable(route = Rute.LOBBY) {
                    HalamanLobbyInovasi(
                        onAksiPindah = { navController.navigate(route = Rute.MENU) }
                    )
                }

                // Menu -> Detail (kirim nama anggota yang diklik)
                composable(route = Rute.MENU) {
                    HalamanMenu(
                        onKembali = { navController.popBackStack() },
                        onAnggotaKlik = { nama -> navController.navigate(route = "${Rute.DETAIL}/$nama") }
                    )
                }

                // Detail (ambil nama anggota dari argumen rute)
                composable(route = "${Rute.DETAIL}/{${Rute.ARG_NAMA}}") { backStackEntry ->
                    val nama = backStackEntry.arguments?.getString(Rute.ARG_NAMA).orEmpty()
                    HalamanDetail(
                        nama = nama,
                        onKembali = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}