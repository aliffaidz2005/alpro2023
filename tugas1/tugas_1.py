#20
batas = int(input('masukan batas: '))

for x in range (batas):
    print(x + 1, end='')
    if (x + 1) % 2 == 0 and (x + 1) % 3 == 0:
        print(' -> FizzBuzz') 
    elif (x + 1) % 2 == 0:
        print(' -> Fizz')
    elif (x + 1) % 3 == 0:
        print(' -> Buzz')
    else:
        print()
