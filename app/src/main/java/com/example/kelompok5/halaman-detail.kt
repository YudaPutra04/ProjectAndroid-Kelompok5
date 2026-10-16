package com.example.kelompok5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Model data satu anggota
data class InfoAnggota(
    val namaLengkap: String,
    val namaPanggilan: String,
    val nim: String,
    val prodi: String,
    val fakultas: String,
    val status: String,
    val fotoAsli: Int
)

// Data semua anggota (urutan ini juga jadi urutan di halaman menu)
val daftarAnggota = listOf(
    InfoAnggota(
        namaLengkap = "Najwatulkholillah Irzal",
        namaPanggilan = "Najwa",
        nim = "2024240021",
        prodi = "Sistem Informasi",
        fakultas = "Teknik",
        status = "Milik Bani",
        fotoAsli = R.drawable.foto_najwa
    ),

    InfoAnggota(
        namaLengkap = "Saskia Dwi Agustina",
        namaPanggilan = "Saskia",
        nim = "2024240026",
        prodi = "Sistem Informasi",
        fakultas = "Teknik",
        status = "Mahasiswa Aktif (Semester 5)",
        fotoAsli = R.drawable.foto_saskia
    ),

    InfoAnggota(
        namaLengkap = "Syifa Fauziah Sarfina",
        namaPanggilan = "Syifa",
        nim = "2024240008",
        prodi = "Sistem Informasi",
        fakultas = "Teknik",
        status = "Mahasiswa Aktif (Semester 5)",
        fotoAsli = R.drawable.foto_syifa
    ),

    InfoAnggota(
        namaLengkap = "Indah Aprilia Pribadi",
        namaPanggilan = "Indah",
        nim = "2024240014",
        prodi = "Sistem Informasi",
        fakultas = "Teknik",
        status = "Mahasiswa Aktif (Semester 5)",
        fotoAsli = R.drawable.foto_indah
    ),

    InfoAnggota(
        namaLengkap = "Yuda Putra Adrian Farrel",
        namaPanggilan = "Yuda",
        nim = "2024240024",
        prodi = "Sistem Informasi",
        fakultas = "Teknik",
        status = "Mahasiswa Aktif (Semester 5)",
        fotoAsli = R.drawable.foto_yuda
    )
)

// Data cadangan kalau nama tidak ditemukan
private val anggotaTidakTerdaftar =
    InfoAnggota(
        namaLengkap = "Tidak Terdaftar",
        namaPanggilan = "Unknown",
        nim = "-",
        prodi = "-",
        fakultas = "-",
        status = "-",
        fotoAsli = R.drawable.foto_kelompok
    )

// Halaman detail: foto dan biodata anggota yang dipilih
@Composable
fun HalamanDetail(nama: String, onKembali: () -> Unit) {
    // Cari anggota berdasarkan nama panggilan
    val anggota = daftarAnggota.find { it.namaPanggilan == nama } ?: anggotaTidakTerdaftar

    Scaffold(
        topBar = { TopBarBiru(judul = "Detail Anggota", onKembali = onKembali) }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(all = 24.dp)) {
            Card(
                shape = RoundedCornerShape(size = 24.dp),
                colors = CardDefaults.cardColors(containerColor = WarnaApp.BiruKartu),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(all = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Foto bulat
                    Image(
                        painter = painterResource(id = anggota.fotoAsli),
                        contentDescription = "Foto ${anggota.namaPanggilan}",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(120.dp).clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Biodata
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                        DetailItem(label = "NAMA LENGKAP", value = anggota.namaLengkap)
                        DetailItem(label = "NAMA PANGGILAN", value = anggota.namaPanggilan)
                        DetailItem(label = "NIM", value = anggota.nim)
                        DetailItem(label = "PROGRAM STUDI", value = anggota.prodi)
                        DetailItem(label = "FAKULTAS", value = anggota.fakultas)
                        DetailItem(label = "STATUS", value = anggota.status)
                    }
                }
            }
        }
    }
}

// Satu baris biodata: label kecil di atas, isi di bawah
@Composable
fun DetailItem(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(text = label, color = WarnaApp.BiruLabel, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Text(text = value, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}