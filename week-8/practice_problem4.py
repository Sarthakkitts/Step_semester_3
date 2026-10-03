import sys
import shlex

def calculate_score(qtype, correct_answer, student_answer, points):
    if qtype == "MCQ" or qtype == "TF":
        if student_answer == correct_answer:
            return float(points)
        else:
            return 0.0
    elif qtype == "ESSAY":
        # correct_answer is comma-separated keywords
        keywords = [k.strip().lower() for k in correct_answer.split(',')]
        student_lower = student_answer.lower()
        match_count = sum(1 for k in keywords if k in student_lower)
        if match_count >= 2:
            return points * 0.75
        elif match_count == 1:
            return points * 0.5
        else:
            return 0.0
    else:
        raise ValueError("Invalid question type")

def main():
    data = sys.stdin.read().strip().splitlines()
    if not data:
        return
    n = int(data[0].strip())
    total = 0.0
    results = []
    for i in range(1, n+1):
        line = data[i].strip()
        if not line:
            continue
        # Use shlex to split preserving quoted strings
        parts = shlex.split(line)
        # Expected: QuestionType QuestionText CorrectAnswer StudentAnswer Points
        if len(parts) < 5:
            continue
        qtype = parts[0]
        # parts[1] is QuestionText (ignore)
        correct_answer = parts[2]
        student_answer = parts[3]
        points = int(parts[4])
        score = calculate_score(qtype, correct_answer, student_answer, points)
        total += score
        results.append((qtype, score))
    for qtype, score in results:
        print(f"{qtype}: {score:.2f}")
    print(f"Total Score: {total:.2f}")

if __name__ == "__main__":
    main()
