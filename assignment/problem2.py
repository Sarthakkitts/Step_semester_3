def bike(hours):
    return 10 * hours

def car(hours):
    if hours <= 0:
        return 0
    return 30 + 20 * (hours - 1)

def truck(hours):
    charge = 50 * hours
    return max(charge, 100)

# Mapping of vehicle type to function
rates = {
    "BIKE": bike,
    "CAR": car,
    "TRUCK": truck
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
        vtype = data[index]
        hours = float(data[index+1])  # hours are whole numbers but we can use float
        index += 2
        charge = rates[vtype](hours)
        print(f"{vtype}: {charge:.2f}")
        total += charge
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()