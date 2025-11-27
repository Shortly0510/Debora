package debo;

import java.util.Scanner;

public class Debo {

    public static void main(String[] args) {
        // TODO code application logic here
        // --- 1. DEKLARASI AWAL ---
        // Kata yang harus ditebak (bisa diganti sesuai keinginan)
        String kataRahasia = "DEBORA";
        
        // Mengubah string menjadi array karakter untuk memantau progress
        // Awalnya kita isi dengan garis bawah '_'
        char[] tebakanPemain = new char[kataRahasia.length()];
        for (int i = 0; i < tebakanPemain.length; i++) {
            tebakanPemain[i] = '_';
        }

        int kesempatan = 5; // Jumlah nyawa
        boolean permainanSelesai = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SELAMAT DATANG DI GAME TEBAK KATA ===");
        System.out.println("Silakan tebak kata rahasia ini huruf per huruf.");
        System.out.println("Pertanyaan: Siapa nama anak paling baik?");
        System.out.println("*Petunjuk: Boru Silitonga");

        // --- 2. LOGIKA PERMAINAN (LOOP) ---
        while (kesempatan > 0 && !permainanSelesai) {
            
            // Tampilkan status kata saat ini (misal: I _ D _ _ _ S _ A)
            System.out.print("\nKata saat ini: ");
            for (char c : tebakanPemain) {
                System.out.print(c + " ");
            }
            System.out.println("\nSisa kesempatan: " + kesempatan);
            
            // Minta input user
            System.out.print("Masukkan satu huruf: ");
            // Mengambil huruf pertama dan mengubah ke huruf besar agar tidak sensitif kapital
            char hurufInput = scanner.next().toUpperCase().charAt(0);

            boolean tebakanBenar = false;

            // --- 3. CEK APAKAH HURUF ADA DI KATA RAHASIA ---
            for (int i = 0; i < kataRahasia.length(); i++) {
                // Jika huruf input cocok dengan huruf di kata rahasia
                if (kataRahasia.charAt(i) == hurufInput) {
                    // Cek apakah huruf itu sudah terbuka sebelumnya
                    if (tebakanPemain[i] == hurufInput) {
                        System.out.println(">> Anda sudah menebak huruf ini sebelumnya!");
                        tebakanBenar = true; // Agar nyawa tidak berkurang
                        break;
                    } else {
                        // Buka huruf tersebut di array tebakanPemain
                        tebakanPemain[i] = hurufInput;
                        tebakanBenar = true;
                    }
                }
            }

            // Feedback ke pemain
            if (tebakanBenar) {
                System.out.println(">> Benar! Huruf '" + hurufInput + "' ada di dalam kata.");
            } else {
                System.out.println(">> Salah! Huruf '" + hurufInput + "' tidak ada.");
                kesempatan--;
            }

            // --- 4. CEK KONDISI MENANG ---
            // Mengubah array char kembali jadi String untuk dibandingkan
            if (String.valueOf(tebakanPemain).equals(kataRahasia)) {
                permainanSelesai = true;
            }
        }

        // --- 5. HASIL AKHIR ---
        System.out.println("-------------------------------------------");
        if (permainanSelesai) {
            System.out.println("SELAMAT! Anda berhasil menebak kata: " + kataRahasia);
        } else {
            System.out.println("GAME OVER. Kesempatan habis.");
            System.out.println("Kata rahasianya adalah: " + kataRahasia);
        }
        
        scanner.close();
    }
    
}

