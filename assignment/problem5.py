from datetime import datetime, timedelta

def parse_date(date_str):
    return datetime.strptime(date_str, "%Y-%m-%d").date()

plan_days = {
    "BASIC": 30,
    "STANDARD": 90,
    "PREMIUM": 365
}

def main():
    import sys
    data = sys.stdin.read().strip().split()
    if not data:
        return
    n = int(data[0])
    index = 1
    for i in range(n):
        plan_type = data[index]
        name = data[index+1]
        start_date_str = data[index+2]
        index += 3
        start_date = parse_date(start_date_str)
        days = plan_days[plan_type]
        renewal_date = start_date + timedelta(days=days)
        print(f"{name}: {renewal_date.isoformat()}")

if __name__ == "__main__":
    main()