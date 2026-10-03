def fulltime(salary):
    return 0.1 * salary

def parttime(salary):
    return 0.05 * salary

def intern(salary):
    return 2000.0

# Mapping of employee type to function
rates = {
    "FULLTIME": fulltime,
    "PARTTIME": parttime,
    "INTERN": intern
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
        etype = data[index]
        name = data[index+1]
        salary = float(data[index+2])
        index += 3
        bonus = rates[etype](salary)
        print(f"{name}: {bonus:.2f}")
        total += bonus
    print(f"Total Bonus: {total:.2f}")

if __name__ == "__main__":
    main()