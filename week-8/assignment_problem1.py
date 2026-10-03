def calculate_final_amount(customer_type, amount):
    if customer_type == "STUDENT":
        return amount * 0.9
    elif customer_type == "STAFF":
        return amount * 0.95
    elif customer_type == "GUEST":
        return amount + 10
    else:
        raise ValueError("Invalid customer type")

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
        customer_type = data[idx]
        amount = float(data[idx+1])
        idx += 2
        final = calculate_final_amount(customer_type, amount)
        total += final
        results.append((customer_type, final))
    for cust_type, final in results:
        print(f"{cust_type}: {final:.2f}")
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()
