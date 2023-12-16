# nama : Alif Faiz 
# Nim  :22315005
# kelas: A
data = int(input('masukan nilai anda : '))
if data >= 85:
    print('predikat anda A')
    print(' IPK 4.00')
elif data >= 80 and data <= 84:
    print('Nilai anda A-')
    print('IPK 3.70')
elif data >= 75 and data <= 79:
    print('Nilai anda B+')
    print('IPK 3.30')
elif data >= 70 and data <= 74:
    print('Nilai anda B')
    print('IPK 3.00')
elif data >= 65 and data  <= 69:
    print('Nilai anda B-')
    print('IPK 2.70')
elif data >= 60 and data <= 64:
    print('Nilai anda C+')
    print('IPK 2.30')
elif data >= 55 and data <= 59:
    print('Nilai anda C')
    print('IPK 2.00')
elif data >= 50 and data  <= 54 :
    print('Nilai anda C-')
    print('IPK 1.70')
elif data >= 40 and data <= 50:
    print('Nilai anda D')
    print('IPK 1.00')
elif data <= 40:
    print('Nilai anda E')

