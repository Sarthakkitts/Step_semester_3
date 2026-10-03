def mcq(correct, student, points):
    return points if correct.lower() == student.lower() else 0.0

def tf(correct, student, points):
    return points if correct.lower() == student.lower() else 0.0

def essay(correct, student, points):
    # Correct answer is comma-separated keywords
    correct_keywords = [k.strip().lower() for k in correct.split(',')]
    student_lower = student.lower()

    # Count how many keywords are present in student answer
    matches = sum(1 for keyword in correct_keywords if keyword in student_lower)

    if matches >= 2:
        return points * 0.75
    elif matches == 1:
        return points * 0.5
    else:
        return 0.0

# Mapping of question type to function
rates = {
    "MCQ": lambda args: mcq(args[0], args[1], args[2]),
    "TF": lambda args: tf(args[0], args[1], args[2]),
    "ESSAY": lambda args: essay(args[0], args[1], args[2])
}

def main():
    import sys
    data = sys.stdin.read().strip().splitlines()
    if not data:
        return
    n = int(data[0].strip())
    total = 0.0
    # Process each of the next n lines
    for i in range(1, n+1):
        line = data[i].strip()
        if not line:
            continue
        # Parse the line: QuestionType QuestionText CorrectAnswer StudentAnswer Points
        # We need to handle quoted strings properly
        parts = []
        current = ""
        in_quotes = False
        for char in line:
            if char == '"' and (not in_quotes or current and current[-1] != '\\'):
                in_quotes = not in_quotes
                current += char
            elif char == ' ' and not in_quotes:
                if current:
                    parts.append(current)
                    current = ""
            else:
                current += char
        if current:
            parts.append(current)

        if len(parts) < 5:
            continue

        qtype = parts[0]
        # Reconstruct quoted strings
        question_text = parts[1]
        correct_answer = parts[2]
        student_answer = parts[3]
        try:
            points = float(parts[4])
        except ValueError:
            continue

        # Remove surrounding quotes if present
        if question_text.startswith('"') and question_text.endswith('"'):
            question_text = question_text[1:-1]
        if correct_answer.startswith('"') and correct_answer.endswith('"'):
            correct_answer = correct_answer[1:-1]
        if student_answer.startswith('"') and student_answer.endswith('"'):
            student_answer = student_answer[1:-1]

        score = rates[qtype](correct_answer, student_answer, points)
        print(f"{qtype}: {score:.2f}")
        total += score
    print(f"Total Score: {total:.2f}")

if __name__ == "__main__":
    main()