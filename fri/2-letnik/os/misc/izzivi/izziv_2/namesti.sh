#!/bin/bash

cat > ~/fun.sh << \EOF
#!/bin/bash

function fibrek () {
    [ -z "$1" ] && N=10 || N=$1
    [ "$N" -le 1 ] && echo $1 || echo $(($(fibrek $(($N - 1))) + $(fibrek $(($N - 2)))))
}

function fibiter () {
    [ -z "$1" ] && N=10 || N=$1
    a=0 b=1  
    
    for (( i = 0; i < $N; i++ )) 
    do
        sum=$((a + b)) 
        a=$b 
        b=$sum 
    done
    echo $a
}

function skupine () {
    for name in $(awk -F: '($3 >= 1000) && ($1 != "nobody") { print $1 }' /etc/passwd)
    do
        groups $name
    done
}

function help () {
    name=$(basename $0)

    echo Script name: $name
    echo Usage: ./$name [ACTION] [...ARGUMENTS]
    echo Example: ./$name fibrek 10
    echo Actions:
    echo "  - fibrek [N]: rekurziven izračun N-tega Fibonaccijevega števila"
    echo "  - fibiter [N]: iterativen izračun N-tega Fibonaccijevega števila"
    echo "  - skupine: izpis vseh uporabnikov in njihovih skupin"
    echo "  - help: kratka pomoč"
}

$1 $2
EOF

chmod +x ~/fun.sh
~/fun.sh help