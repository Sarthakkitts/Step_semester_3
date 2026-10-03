def calculate_bill(room_type, units, occupants=None):
    if room_type == "SINGLE":
        return units * 8
    elif room_type == "SHARED":
        if occupants is None or occupants < 2:
            raise ValueError("Shared room requires occupants >=2")
        return (units * 6) / occupants
    elif room_type == "AC":
        return units * 10 + 200
    else:
        raise ValueError("Invalid room type")

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
        room_type = data[idx]
        units = float(data[idx+1])
        idx += 2
        occupants = None
        if room_type == "SHARED":
            occupants = int(data[idx])
            idx += 1
        bill = calculate_bill(room_type, units, occupants)
        total += bill
        results.append((room_type, bill))
    for rtype, bill in results:
        print(f"{rtype}: {bill:.2f}")
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()
