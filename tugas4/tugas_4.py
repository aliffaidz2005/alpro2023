# file i/o ada dua mode
# mode pertama -> baca (READ) r
# mode ke dua -> tulis (WRITE) w

if __name__ == "__main__":
    nama_file = "tes.txt"
    teks = "aku akan menjadi programer setelah lulus kuliah"

    # contoh write atau tulis
    with open (nama_file, "w") as f:
        f.write(teks)
        

    # contoh read atau baca
    with open(nama_file, "r") as f:
        print(f.read())