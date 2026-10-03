def calculate_delivery_fee(delivery_type, weight, distance, customs_fee=0):
    if delivery_type == "STANDARD":
        return 5 + 0.5 * weight + 0.1 * distance
    elif delivery_type == "EXPRESS":
        return 15 + 1.0 * weight + 0.2 * distance
    elif delivery_type == "INTERNATIONAL":
        return 25 + 2.0 * weight + 0.5 * distance + customs_fee
    else:
        raise ValueError("Invalid delivery type")

def main():
    import sys
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    idx = 1
    total = 0.0
    results = []
    for _ in range(n):
        delivery_type = data[idx]
        weight = float(data[idx+1])
        distance = float(data[idx+2])
        idx += 3
        customs_fee = 0.0
        if delivery_type == "INTERNATIONAL":
            customs_fee = float(data[idx])
            idx += 1
        fee = calculate_delivery_fee(delivery_type, weight, distance, customs_fee)
        total += fee
        results.append((delivery_type, fee))
    for dtype, fee in results:
        print(f"{dtype}: {fee:.2f}")
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()
