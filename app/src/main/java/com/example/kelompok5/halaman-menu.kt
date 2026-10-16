package com.example.kelompok5

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Top bar biru dengan tombol kembali (dipakai di Menu dan Detail)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBiru(judul: String, onKembali: () -> Unit) {
    TopAppBar(
        title = { Text(judul, fontWeight = FontWeight.Bold) },
        navigationIcon = {
            IconButton(onClick = onKembali) {
                Text("⬅", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = WarnaApp.BiruMuda)
    )
}

// Halaman menu: daftar anggota dalam grid 2 kolom
@Composable
fun HalamanMenu(onKembali: () -> Unit, onAnggotaKlik: (String) -> Unit) {
    // Nama diambil dari data anggota (halaman-detail.kt) supaya tidak dobel
    val daftarNama = daftarAnggota.map { it.namaPanggilan }

    Scaffold(
        topBar = { TopBarBiru(judul = "Menu Anggota", onKembali = onKembali) }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(all = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(daftarNama) { nama ->
                // Kartu anggota, klik -> buka detail
                Card(
                    shape = RoundedCornerShape(size = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = WarnaApp.BiruUtama),
                    modifier = Modifier.height(120.dp).clickable { onAnggotaKlik(nama) }
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(text = nama, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}