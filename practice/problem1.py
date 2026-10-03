def card(amount):
    return amount * 1.02

def wallet(amount):
    return amount * 1.01

def banktransfer(amount):
    return amount

# Mapping of payment type to function
rates = {
    "CARD": card,
    "WALLET": wallet,
    "BANKTRANSFER": banktransfer
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
        ptype = data[index]
        amount = float(data[index+1])
        index += 2
        final = rates[ptype](amount)
        print(f"{ptype}: {final:.2f}")
        total += final
    print(f"Total: {total:.2f}")

if __name__ == "__main__":
    main()