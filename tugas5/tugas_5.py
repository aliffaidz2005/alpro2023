import os.path
nama_file = "text.txt"

def simpan_text(text_):
    with open (nama_file, "w") as f:
        f.write(text_)

def load_text():
    if not os.path.exists(nama_file):
        return
    
    with open(nama_file, "r") as f:
        return f.read()
if __name__ == "__main__":
    text = load_text()

    if text is not None:
        baris = text.split("\n")
    else:
        baris = []
    data_mahasiswa = {}

    for baris_n in baris:
        key, value  =baris_n.split(",")
        data_mahasiswa[key] =value

    print(data_mahasiswa)

