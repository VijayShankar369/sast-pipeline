import sqlite3

# Hardcoded credentials - will be detected
DATABASE_PASSWORD = "admin123!"
API_SECRET_KEY = "sk-1234567890abcdef"

def authenticate_user(username, password):
    conn = sqlite3.connect("app.db")
    cursor = conn.cursor()
    
    # SQL injection vulnerability - will be detected
    query = f"SELECT * FROM users WHERE username = '{username}'"
    cursor.execute(query)
    return cursor.fetchone()

if __name__ == "__main__":
    result = authenticate_user("admin' OR '1'='1", "any")
    print("Result:", result)
EOF
