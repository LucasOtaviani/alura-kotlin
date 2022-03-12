fun main() {
    println("Welcome to Bytebank")

    val alexAccount = Account(titular = "Alex", number = 1000)
    alexAccount.deposit(200.0)

    val franAccount = Account(titular = "Fran", number = 1001)
    franAccount.deposit(300.0)

    println(franAccount.titular)
    println(franAccount.number)
    println(franAccount.balance)

    println(alexAccount.titular)
    println(alexAccount.number)
    println(alexAccount.balance)

    println("Depositing into the account of Alex")
    alexAccount.deposit(50.0)
    println(alexAccount.balance)

    println("Depositing into the account of Fran")
    franAccount.deposit(70.0)
    println(franAccount.balance)

    println("Withdrawing from Alex's account")
    alexAccount.withdraw(250.0)
    println(alexAccount.balance)

    println("Withdrawing from Fran's account")
    franAccount.withdraw(100.0)
    println(franAccount.balance)

    println("Excessive withdrawal from Alex's account")
    alexAccount.withdraw(100.0)
    println(alexAccount.balance)

    println("Excessive withdrawal from Fran's account")
    franAccount.withdraw(500.0)
    println(franAccount.balance)

    println("Transfer from Fran's account to Alex")

    if (franAccount.transfer(destinationAccount = alexAccount, value = 300.0)) {
        println("Successful transfer")
    } else {
        println("Transfer failure")
    }

    println(alexAccount.balance)
    println(franAccount.balance)
}

class Account(
    var titular: String,
    val number: Int
) {
    var balance = 0.0
        private set

    fun deposit(value: Double) {
        if (value > 0) {
            this.balance += value
        }
    }

    fun withdraw(value: Double) {
        if (balance >= value) {
            balance -= value
        }
    }

    fun transfer(value: Double, destinationAccount: Account): Boolean {
        if (balance >= value) {
            balance -= value
            destinationAccount.deposit(value)

            return true
        }

        return false
    }
}

fun testCopyAndReferences() {
    val numberX = 10
    var numberY = numberX
    numberY++

    println("numberX $numberX")
    println("numberY $numberY")

    val accountJoao = Account("João", 1002)
    accountJoao.titular = "João"

    var accountMaria = Account("Maria", 1003)
    accountMaria.titular = "Maria"

    accountJoao.titular = "João"

    println("Titular from Joao's account: ${accountJoao.titular}")
    println("Titular from Maria's account: ${accountMaria.titular}")

    println(accountJoao)
    println(accountMaria)
}

fun testLoops() {
    var i = 0

    while (i < 5) {
        val titular: String = "Alex $i"
        val accountNumber: Int = 1000 + i
        var balance = i + 10.0

        println("titular $titular")
        println("Account number: $accountNumber")
        println("Account balance: $balance")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        val titular: String = "Alex $i"
        val accountNumber: Int = 1000 + i
        var balance = i + 10.0

        println("titular $titular")
        println("Account number: $accountNumber")
        println("Account balance: $balance")
        println()
    }
}

fun testConditions(balance: Double) {
    if (balance > 0.0) {
        println("Account is positive")
    } else if (balance == 0.0) {
        println("Account is neutral")
    } else {
        println("Account is negative")
    }

    when {
        balance > 0.0 -> println("Account is positive")
        balance == 0.0 -> println("Account is neutral")
        else -> println("Account is negative")
    }
}