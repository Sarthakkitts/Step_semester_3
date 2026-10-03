from datetime import date, timedelta

# Fixed current date as per problem
CURRENT_DATE = date(2023, 10, 26)

# Borrowing periods in days
periods = {
    "BOOK": 14,
    "DVD": 7,
    "MAGAZINE": 3
}

def main():
    import sys
    data = sys.stdin.read().strip().splitlines()
    if not data:
        return
    n = int(data[0].strip())
    # Process each of the next n lines
    for i in range(1, n+1):
        line = data[i].strip()
        if not line:
            continue
        # Split the line: first token is item type, the rest is the title (possibly quoted and with spaces)
        parts = line.split()
        if not parts:
            continue
        item_type = parts[0]
        # The title is the rest of the line after the first word
        title = ' '.join(parts[1:]).strip('"')  # Remove surrounding quotes if any
        # Calculate due date
        days = periods.get(item_type)
        if days is None:
            # Unknown item type, skip or handle error
            continue
        due_date = CURRENT_DATE + timedelta(days=days)
        print(f"{title}: {due_date.isoformat()}")

if __name__ == "__main__":
    main()