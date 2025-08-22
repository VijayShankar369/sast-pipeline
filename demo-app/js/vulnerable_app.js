// Hardcoded credentials - will be detected
const DATABASE_PASSWORD = "admin123!";
const API_SECRET_KEY = "sk-1234567890abcdef";

function authenticateUser(username, password) {
    // SQL injection - will be detected  
    const query = `SELECT * FROM users WHERE username = '${username}'`;
    console.log("Query:", query);
    return true;
}

// Test with injection payload
authenticateUser("admin' OR '1'='1", "any");
EOF
