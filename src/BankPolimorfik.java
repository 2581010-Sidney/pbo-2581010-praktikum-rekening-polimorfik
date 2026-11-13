
public class BankPolimorfik {
    public static void main(String[] args) {
      Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
      Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
      Giro budi = new Giro("201", "Budi", 200000, 500000);

      Rekening[] semua = {ani, citra, budi};
      BerBunga[] berbunga = {ani, citra};

      System.out.println("========== REKENING AWAL ==========");
      for (Rekening r : semua) {
          r.cetakInfo();
      }

      System.out.println();
      System.out.println("========== ");
    }
}