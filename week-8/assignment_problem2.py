def calculate_parking_charge(vehicle_type, hours):
    if vehicle_type == "BIKE":
        return hours * 10
    elif vehicle_type == "CAR":
        if hours <= 1:
            return 30
        else:
            return 30 + (hours - 1) * 20
    elif vehicle_type == "TRUCK":
        charge = hours * 50
        if charge < 100:
            return 100
        else:
            return charge
    else:
        raise ValueError("Invalid vehicle type")

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
        vehicle_type = data[idx]
        hours = int(data[idx+1])
        idx += 2
        charge = calculate_parking_charge(vehicle_type, hours)
        total += charge
        results.append((vehicle_type, charge))
    for vtype, charge in results:
        print(f"{vtype}: {charge:.2f}")
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()
