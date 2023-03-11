h, m = map(int,input().split())
time = int(input())

input_m = h*60 + m
output_m = input_m + time

final_h, final_m = output_m//60, output_m%60

if final_h >= 24:
    final_h %=24
print(final_h, final_m)

    