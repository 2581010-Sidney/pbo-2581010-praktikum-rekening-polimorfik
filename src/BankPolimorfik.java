
public class BankPolimorfik {
    public static void main(String[] args) {

//        Percobaan  : Rekening r = new Rekening("999", "eko", 0);
//        Pesan error: java: Rekening is abstract; cannot be instantiated
          Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5); // adalah rekening juga
          Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
          Giro budi = new Giro("201", "Budi", 200000, 500000);

          Rekening[] semua = {ani, citra, budi};
          BerBunga[] berbunga = {ani, citra};

          System.out.println("========== REKENING AWAL ==========");
          for (Rekening r : semua) {
              r.cetakInfo();  // Polymorphism: perintah yang sama tapi hasilnya beda tegantung obj. cth: Tabungan dan Giro.
          }

          System.out.println();
          System.out.println("========== AKHIR BULAN ==========");
          for (Rekening r : semua) {
              System.out.println(String.format("%s biaya admin  : %s",r.getNomor(), Rekening.formatRupiah(r.potongBiayaAdmin())));
          }
          for (BerBunga b : berbunga) {
              System.out.println(String.format("%s bunga        : %s", b.getNomor(), Rekening.formatRupiah(b.tambahBunga())));
          }

          System.out.println();
          System.out.println("========== REKENING AKHIR ==========");
          int total = 0;
          for (Rekening r : semua){
              r.cetakInfo();
              total += r.getSaldo();
          }
          System.out.println("-------------------------------------");
          System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}