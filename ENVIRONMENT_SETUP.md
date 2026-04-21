# 🔧 Environment Setup & Configuration Guide

## Quick Start

### Prerequisites
- Java JDK 8+ (currently configured for 1.8)
- Maven 3.6+ OR Gradle 6.0+
- BrowserStack account with credentials

---

## 🔐 Setting Up BrowserStack Credentials

### Method 1: Environment Variables (Recommended for Production/CI-CD)

#### Windows PowerShell
```powershell
$env:BROWSERSTACK_USERNAME = "your_browserstack_username"
$env:BROWSERSTACK_ACCESS_KEY = "your_browserstack_access_key"

# Verify setup
echo $env:BROWSERSTACK_USERNAME
echo $env:BROWSERSTACK_ACCESS_KEY

# Run tests with environment variables
mvn clean test
# OR
./gradlew clean test
```

#### Windows Command Prompt
```cmd
set BROWSERSTACK_USERNAME=your_browserstack_username
set BROWSERSTACK_ACCESS_KEY=your_browserstack_access_key

# Verify setup
echo %BROWSERSTACK_USERNAME%
echo %BROWSERSTACK_ACCESS_KEY%

# Run tests
mvn clean test
```

#### Linux/macOS
```bash
export BROWSERSTACK_USERNAME="your_browserstack_username"
export BROWSERSTACK_ACCESS_KEY="your_browserstack_access_key"

# Verify setup
echo $BROWSERSTACK_USERNAME
echo $BROWSERSTACK_ACCESS_KEY

# Run tests
mvn clean test
```

### Method 2: Default Fallback (Development Only)

If environment variables are not set, the code will use default values defined in `SeleniumTest.java`:
- Default USERNAME: `sathishselvaraj_0eCocD`
- Default ACCESS_KEY: `ArhXgDKkWynrzWXRpvJ8`

⚠️ **WARNING:** These are hardcoded for development purposes only. Replace with your own credentials in production.

---

## 📝 Configure Test Credentials

### Edit config.properties

File: `src/test/resources/config.properties`

```properties
# Application URL
app.url=https://qa-connect.phoenixhse.com/

# Default test user credentials
# Change these to your test user account
test.username=shakeel.s22
test.password=Welcome1234@

# Attachment path
attachment.path=C:/Users/sselvaraj01/Pictures/Screenshots/Screenshot 2025-03-04 123127.png

# Build & tags
buildName=ConnectApp_Build_101
customTag1=POM
customTag2=Regression
customTag3=SmokeTest
customTag4=Critical
customTag5=Sprint25
```

### Updating Test User Credentials

Replace the following values in `config.properties`:
```properties
test.username=your_test_username    # e.g., shakeel.s22
test.password=your_test_password    # e.g., Welcome1234@
```

---

## 🏗️ Build & Test Execution

### Using Maven

#### Build Project
```bash
mvn clean compile
```

#### Run All Tests
```bash
mvn clean test
```

#### Run Specific Test Class
```bash
mvn clean test -Dtest=ConnectLoginTest
```

#### Run with Custom Configuration
```bash
mvn clean test -Dtest=ConnectLoginTest -DsuiteXmlFile=config/sample-test.testng.xml
```

### Using Gradle

#### Build Project
```bash
./gradlew clean build
```

#### Run All Tests
```bash
./gradlew clean test
```

#### Run Specific Test Task
```bash
./gradlew sampleTest
```

---

## 🔄 CI/CD Integration

### GitHub Actions Example

Create `.github/workflows/tests.yml`:

```yaml
name: TestNG BrowserStack Tests

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main, develop ]

jobs:
  test:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up Java
      uses: actions/setup-java@v2
      with:
        java-version: '8'
    
    - name: Run tests with Maven
      env:
        BROWSERSTACK_USERNAME: ${{ secrets.BROWSERSTACK_USERNAME }}
        BROWSERSTACK_ACCESS_KEY: ${{ secrets.BROWSERSTACK_ACCESS_KEY }}
      run: mvn clean test

    - name: Publish Test Reports
      if: always()
      uses: dorny/test-reporter@v1
      with:
        name: TestNG Results
        path: 'target/test-results/**/*.xml'
        reporter: 'java-testng'
```

### Jenkins Pipeline Example

```groovy
pipeline {
    agent any
    
    environment {
        BROWSERSTACK_USERNAME = credentials('browserstack-username')
        BROWSERSTACK_ACCESS_KEY = credentials('browserstack-access-key')
    }
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo/testng-browserstack.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Report') {
            steps {
                junit 'target/test-results/*.xml'
            }
        }
    }
}
```

---

## 🧪 Test Execution Examples

### Run Positive Login Test Only
```powershell
$env:BROWSERSTACK_USERNAME = "your_username"
$env:BROWSERSTACK_ACCESS_KEY = "your_key"
mvn clean test -Dtest=ConnectLoginTest#appPositiveLogin
```

### Run All Tests in Suite
```powershell
$env:BROWSERSTACK_USERNAME = "your_username"
$env:BROWSERSTACK_ACCESS_KEY = "your_key"
mvn clean test -DsuiteXmlFile=src/test/resources/Test\ Suites/testNg.Xml
```

### Run with Different Browser
The tests are configured to run with Chrome by default. To use other browsers, modify `src/test/resources/Test Suites/testNg.Xml`:

```xml
<test name="Positive Login Test">
    <parameter name="browser" value="firefox"/>  <!-- Change to firefox or edge -->
    <classes>
        <class name="tests.ConnectLoginTest"/>
    </classes>
</test>
```

---

## 🔍 Troubleshooting

### Issue: "BROWSERSTACK_USERNAME not found"
**Solution:** Ensure environment variables are set before running tests
```powershell
# Windows
set BROWSERSTACK_USERNAME=your_username
set BROWSERSTACK_ACCESS_KEY=your_key

# Linux/Mac
export BROWSERSTACK_USERNAME="your_username"
export BROWSERSTACK_ACCESS_KEY="your_key"
```

### Issue: "BrowserStack SDK not available at runtime"
**Solution:** Project has been fixed. Ensure `build.gradle` has:
```groovy
implementation 'com.browserstack:browserstack-java-sdk:1.41.4'
```

### Issue: "Wrong test suite being executed"
**Solution:** Verify pom.xml references the correct suite:
```xml
<suiteXmlFile>src/test/resources/Test Suites/testNg.Xml</suiteXmlFile>
```

### Issue: "Selenium element not found"
**Solution:** Check that BrowserStack session has connected and wait times are sufficient:
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.presenceOfElementLocated(locator));
```

---

## 📊 Test Configuration Overview

### Test Suite Structure

```
src/test/resources/Test Suites/
├── testNg.Xml (Main test suite)
│   ├── Positive Login Test
│   ├── Leave Request Test
│   ├── Catering Topup Test
│   └── Transport Service Request Test
```

### Test Classes

- **ConnectLoginTest.java** - Login functionality (2 tests)
  - Positive login flow
  - Negative login with invalid credentials

- **ConnectLeaveRequest.java** - Leave request submission (1 test)
  
- **CateringTest.java** - Catering top-up functionality (1 test)

- **TransportServiceRequest.java** - Transport request submission (1 test)

### Total Tests: 5

---

## 🎯 Best Practices

1. **Always use environment variables for credentials in production**
   - Never commit actual credentials to repository
   - Use .gitignore to exclude config files

2. **Use explicit waits instead of Thread.sleep()**
   ```java
   // ❌ Bad
   Thread.sleep(3000);
   
   // ✅ Good
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   ```

3. **Use Page Object Model for maintainability**
   - All UI interactions in dedicated page classes
   - Tests focus on what to test, not how to test

4. **Parameterize test data**
   - Use config files for environment-specific data
   - Use @DataProvider for test variations

5. **Add proper logging**
   ```java
   private Logger logger = Logger.getLogger(MyTest.class.getName());
   logger.info("Test execution started");
   ```

---

## 📚 Additional Resources

- [BrowserStack Documentation](https://www.browserstack.com/docs)
- [Selenium 4 Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/)
- [Maven Documentation](https://maven.apache.org/)
- [Gradle Documentation](https://gradle.org/guides/)

---

## ✅ Setup Verification Checklist

- [ ] Java JDK 8+ installed
- [ ] Maven or Gradle installed
- [ ] BrowserStack credentials obtained
- [ ] Environment variables set (BROWSERSTACK_USERNAME, BROWSERSTACK_ACCESS_KEY)
- [ ] config.properties updated with test user credentials
- [ ] Project builds successfully: `mvn clean compile`
- [ ] Dependencies resolve: `mvn dependency:resolve`
- [ ] Ready to run tests: `mvn clean test`

---

**Last Updated:** April 21, 2026
**Version:** 1.0


