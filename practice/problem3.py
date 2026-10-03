def standard(weight, distance):
    return 5 + 0.5 * weight + 0.1 * distance

def express(weight, distance):
    return 15 + 1.0 * weight + 0.2 * distance

def international(weight, distance, customs_fee):
    return 25 + 2.0 * weight + 0.5 * distance + customs_fee

# Mapping of delivery type to function
rates = {
    "STANDARD": lambda args: standard(args[0], args[1]),
    "EXPRESS": lambda args: express(args[0], args[1]),
    "INTERNATIONAL": lambda args: international(args[0], args[1], args[2])
}

def main():
    import sys
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    total = 0.0
    index = 1
    for i in range(n):
        dtype = data[index]
        # Determine how many numbers follow based on delivery type
        if dtype == "STANDARD" or dtype == "EXPRESS":
            count = 2  # Weight, Distance
        elif dtype == "INTERNATIONAL":
            count = 3  # Weight, Distance, CustomsFee
        else:
            # Unknown type, skip
            break
        nums = list(map(float, data[index+1:index+1+count]))
        index += 1 + count
        fee = rates[dtype](nums)
        print(f"{dtype}: {fee:.2f}")
        total += fee
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()