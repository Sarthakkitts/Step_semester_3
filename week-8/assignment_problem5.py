import sys
from datetime import datetime, timedelta

def get_validity_days(plan_type):
    if plan_type == "BASIC":
        return 30
    elif plan_type == "STANDARD":
        return 90
    elif plan_type == "PREMIUM":
        return 365
    else:
        raise ValueError("Invalid plan type")

def main():
    data = sys.stdin.read().strip().splitlines()
    if not data:
        return
    n = int(data[0].strip())
    results = []
    for i in range(1, n+1):
        line = data[i].strip()
        if not line:
            continue
        parts = line.split()
        plan_type = parts[0]
        name = parts[1]
        start_date_str = parts[2]
        start_date = datetime.strptime(start_date_str, "%Y-%m-%d")
        validity = get_validity_days(plan_type)
        renewal_date = start_date + timedelta(days=validity)
        results.append((name, renewal_date.strftime("%Y-%m-%d")))
    for name, renewal in results:
        print(f"{name}: {renewal}")
    # No total required per problem statement

if __name__ == "__main__":
    main()
