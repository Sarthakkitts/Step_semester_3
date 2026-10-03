def calculate_bonus(emp_type, monthly_salary):
    if emp_type == "FULLTIME":
        return monthly_salary * 0.10
    elif emp_type == "PARTTIME":
        return monthly_salary * 0.05
    elif emp_type == "INTERN":
        return 2000.0
    else:
        raise ValueError("Invalid employee type")

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
        emp_type = data[idx]
        name = data[idx+1]
        salary = float(data[idx+2])
        idx += 3
        bonus = calculate_bonus(emp_type, salary)
        total += bonus
        results.append((name, bonus))
    for name, bonus in results:
        print(f"{name}: {bonus:.2f}")
    print(f"Total Bonus: {total:.2f}")

if __name__ == "__main__":
    main()
