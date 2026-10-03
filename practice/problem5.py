def bus(distance):
    fare = 2 + 0.1 * distance
    return min(fare, 10.0)  # Max fare $10

def train(distance):
    return 3 + 0.15 * distance

def metro(distance, peak_hour_factor):
    return (1.5 + 0.2 * distance) * peak_hour_factor

# Mapping of transport type to function
rates = {
    "BUS": lambda args: bus(args[0]),
    "TRAIN": lambda args: train(args[0]),
    "METRO": lambda args: metro(args[0], args[1])
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
        ttype = data[index]
        # Determine how many numbers follow based on transport type
        if ttype == "BUS" or ttype == "TRAIN":
            count = 1  # Distance
        elif ttype == "METRO":
            count = 2  # Distance, PeakHourFactor
        else:
            # Unknown type, skip
            break
        nums = list(map(float, data[index+1:index+1+count]))
        index += 1 + count
        fare = rates[ttype](nums)
        print(f"{ttype}: {fare:.2f}")
        total += fare
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()