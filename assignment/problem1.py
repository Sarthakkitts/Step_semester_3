def student(amount):
    return amount * 0.9  # 10% discount

def staff(amount):
    return amount * 0.95  # 5% discount

def guest(amount):
    return amount + 10  # full amount plus ₹10 service charge

# Mapping of customer type to function
rates = {
    "STUDENT": student,
    "STAFF": staff,
    "GUEST": guest
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
        cust_type = data[index]
        amount = float(data[index+1])
        index += 2
        final = rates[cust_type](amount)
        print(f"{cust_type}: {final:.2f}")
        total += final
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()