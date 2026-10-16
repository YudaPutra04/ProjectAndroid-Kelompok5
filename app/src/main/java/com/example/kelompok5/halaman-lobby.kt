package com.example.kelompok5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Halaman pembuka: judul, foto kelompok, dan tombol menuju menu
@Composable
fun HalamanLobbyInovasi(onAksiPindah: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(all = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Judul
        Text(
            text = "SELAMAT DATANG DI\nLOBBY KELOMPOK 5",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = WarnaApp.BiruTua,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Foto kelompok
        Card(
            shape = RoundedCornerShape(size = 24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier.size(240.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto_kelompok),
                contentDescription = "Foto Kelompok 5",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Tombol menuju halaman menu
        Button(
            onClick = onAksiPindah,
            shape = RoundedCornerShape(size = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = WarnaApp.BiruUtama),
            modifier = Modifier.fillMaxWidth(fraction = 0.9f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Kenali Kami Lebih Dekat",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                // Ikon panah dalam lingkaran putih
                Surface(shape = CircleShape, color = Color.White, modifier = Modifier.size(28.dp)) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("➔", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}