public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo); //super: untuk memanggil constuctor/method dari parent
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public int biayaAdminBulanan(){
        return 15000;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || saldo - jumlah < -batasOverdraft){ // apakah jumlah < dari 0 || apakah s-j lebih rendah dari -batas?
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public void cetakInfo(){
        super.cetakInfo();
        System.out.println("       Giro, batas overdraft " + formatRupiah(batasOverdraft));
    }
}
