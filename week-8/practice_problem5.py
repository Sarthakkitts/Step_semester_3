def calculate_fare(transport_type, distance, peak_factor=1.0):
    if transport_type == "BUS":
        fare = 2 + 0.1 * distance
        if fare > 10:
            fare = 10
        return fare
    elif transport_type == "TRAIN":
        return 3 + 0.15 * distance
    elif transport_type == "METRO":
        return (1.5 + 0.2 * distance) * peak_factor
    else:
        raise ValueError("Invalid transport type")

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
        transport_type = data[idx]
        distance = float(data[idx+1])
        idx += 2
        peak_factor = 1.0
        if transport_type == "METRO":
            peak_factor = float(data[idx])
            idx += 1
        fare = calculate_fare(transport_type, distance, peak_factor)
        total += fare
        results.append((transport_type, fare))
    for ttype, fare in results:
        print(f"{ttype}: {fare:.2f}")
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()
