class Bidangdatar:
    luas = None
    jenis = None

def Luas_Segitiga():
    print()
    print('Luas_Segitiga')
    alas = int(input('Masukan alas : '))
    tinggi = int(input('Masukan tinggi : '))
    luas = 0.5 * alas * tinggi

    bidang_datar = Bidangdatar()
    bidang_datar.luas = luas
    bidang_datar.jenis = 'segitiga'

    return bidang_datar

def  luas_persegi_panjang():
    bidang_datar = ('persegi panjaang')
    print()
    print('luas_persegi_panjang')
    panjang = int(input('Masukan panjang : '))
    lebar = int(input('Masukan lebar : '))
    luas = panjang * lebar

    bidang_datar = Bidangdatar()
    bidang_datar.luas = luas
    bidang_datar.jenis = jenis = 'persegi panjang'

    return bidang_datar

def luas_lingkaran():
    bidang_datar ='lingkaran'
    print()
    print('Luas lingkaran')
    jarijari = int(input('Masukan jari jari : '))
    luas = 3.14 * jarijari * jarijari

    bidang_datar =  Bidangdatar()
    bidang_datar.luas = luas
    bidang_datar.jenis = 'lingkaran'

    return bidang_datar

def luas_jajar_genjang():
    bidang_datar ='jajargenjang'
    print()
    print('luas_jajar_genjang')
    alas = int(input('Masukan alas : '))
    tinggi = int(input('Masukan alas : '))
    luas = alas * tinggi 

    bidang_datar = Bidangdatar()
    bidang_datar.luas = luas
    bidang_datar.jenis = 'jajargenjang'

    return bidang_datar

if __name__ == '__main__':

    while True:
        print('Menu')
        print('==================')
        print(' 1. Luas_segitiga')
        print('2. Luas_persegi_panjang')
        print('3. luas_lingkaran')
        print('4. luas_jejer genjang')
        print('5. keluar')
        menu = int(input('pilih menu : '))

        if menu == 5:
            break
        if menu  == 1:
            bidang_datar = Luas_Segitiga()
        elif menu  == 2:
            bidang_datar = luas_persegi_panjang()
        elif menu == 3:
            bidang_datar = luas_lingkaran()
        elif menu == 4:
            bidang_datar = luas_jajar_genjang()
        print('luas {} adalah : {}'.format(bidang_datar.jenis,bidang_datar.luas))
        print()




