def single(units):
    return 8 * units

def shared(units, occupants):
    return (6 * units) / occupants

def ac(units):
    return 10 * units + 200

# Mapping of room type to function
# Note: shared requires two parameters, others one.
# We'll design the function to accept a list of numbers.
rates = {
    "SINGLE": lambda nums: single(nums[0]),
    "SHARED": lambda nums: shared(nums[0], nums[1]),
    "AC": lambda nums: ac(nums[0])
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
        rtype = data[index]
        # Determine how many numbers follow based on room type
        if rtype == "SINGLE" or rtype == "AC":
            count = 1
        elif rtype == "SHARED":
            count = 2
        else:
            # Unknown type, skip
            break
        nums = list(map(float, data[index+1:index+1+count]))
        index += 1 + count
        bill = rates[rtype](nums)
        print(f"{rtype}: {bill:.2f}")
        total += bill
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()