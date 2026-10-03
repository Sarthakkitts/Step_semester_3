def calculate_adjusted_amount(payment_type, amount):
    if payment_type == "CARD":
        return amount * 1.02
    elif payment_type == "WALLET":
        return amount * 1.01
    elif payment_type == "BANKTRANSFER":
        return amount
    else:
        raise ValueError("Invalid payment type")

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
        payment_type = data[idx]
        amount = float(data[idx+1])
        idx += 2
        adjusted = calculate_adjusted_amount(payment_type, amount)
        total += adjusted
        results.append((payment_type, adjusted))
    for ptype, adj in results:
        print(f"{ptype}: {adj:.2f}")
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()
