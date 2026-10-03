import sys
from datetime import datetime, timedelta

CURRENT_DATE = datetime(2023, 10, 26).date()

def get_borrowing_days(item_type):
    if item_type == "BOOK":
        return 14
    elif item_type == "DVD":
        return 7
    elif item_type == "MAGAZINE":
        return 3
    else:
        raise ValueError("Invalid item type")

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
        # Split by whitespace, but title may be quoted and contain spaces? Assume no spaces.
        parts = line.split()
        item_type = parts[0]
        # Rejoin the rest as title and strip quotes
        title = " ".join(parts[1:]).strip('"')
        days = get_borrowing_days(item_type)
        due_date = CURRENT_DATE + timedelta(days=days)
        results.append((title, due_date.strftime("%Y-%m-%d")))
    for title, due in results:
        print(f"{title}: {due}")
    # No total

if __name__ == "__main__":
    main()
