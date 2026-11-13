public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo; // boleh diakses class turunan

    public Rekening(String nomor, String pemilik, int saldo){
        this.nomor = nomor; // field(data) milik objek Rekening | pareameter saat new Rekening
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor(){
        return nomor;
    }

    public String getPemilik(){
        return pemilik;
    }
    public int getSaldo(){ //diluar class, data ga bisa diubah langsung, hanya bisa lewat setor dan tarik.
        return saldo;
    }

    public boolean setor(int jumlah){
        if (jumlah<=0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah){
        if (jumlah<=0 || jumlah>saldo){
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public abstract int biayaAdminBulanan(); // semua subclass biasa wajub melakukan override

    public int potongBiayaAdmin(){
        int biaya = biayaAdminBulanan(); // versi object sebenarnya
        saldo -= biaya;
        return biaya;
    }

    public void cetakInfo() {
        System.out.println(String.format("%s | %-6s | %12s", nomor, pemilik, formatRupiah(saldo)));
    }

    // bisa di pakai di class turunan
    protected static String formatRupiah(int angka) {
        return "Rp" + String.format("%,d", angka).replace(',', '.');
    }
}

