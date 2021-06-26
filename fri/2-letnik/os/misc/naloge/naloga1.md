```bash
#!/bin/bash
RANDOM=42

function pomoc() {
    echo "Uporaba: $(basename $0) akcija parametri"
}

function hehho() {
    for (( i = 2; i <= $#; i++ )); do
        var=${!i}
        param="";
        for (( j = 0; j < ${#var}; j++ )); do
            char="${var:$j:1}"
            case $char in
                "a") char="ha" ;;
                "e") char="he" ;;
                "i") char="hi" ;;
                "o") char="ho" ;;
                "u") char="hu" ;;
                *) ;;
            esac
            param="$param$char"
        done

        echo "$(expr $i - 2): $param"
    done
    exit 0
}

function gcd() {
    if (( $1 % $2 == 0 )); then
        echo $2
    else
        gcd $2 $(( $1 % $2 ))
    fi
}

function status() {
    value=$(gcd $2 $3);
    echo $value
    exit $(expr $value % 256)
}

function leto() {
    for (( i = 1; i <= $#; i++ )); do
        leto=${!i}
        prestopno="ni"

        if !(( $leto % 4 )); then
            if !(( $leto % 100 )); then
                if !(( $leto % 400 )); then
                    prestopno="je"
                fi
            else
                prestopno="je"
            fi
        fi

        echo "Leto $leto $prestopno prestopno."
    done
    exit 0
}

function stej() {
    for (( i = 1; i <= $#; i++ )); do
        path=${!i}
        echo -e $(cat $path)
    done
    exit 0
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

function fib() {
    for (( i = $#; i > 0 ; i-- )); do
        num=${!i}
        echo "$num: $(fibiter $num)"
    done
    exit 0
}

function upori() {
    for (( i = 1; i <= $#; i++ )); do
        username=${!i}
        if id "$username" &> /dev/null; then
            uid=$(id -u $username)
            gid=$(id -g $username)

            local enaka="enaka"
            if [ $uid -ne $gid ]; then 
                enaka="razlicna"
            fi

            local obstaja="ne-obstaja"
            local passw_str=$(getent passwd "$username" | cut -d: -f6)
            ! [ -z "$passw_str" ] && [ -d "$passw_str" ] && obstaja="obstaja"

            local groups=$(groups $username | wc -w)
            local processes=$(wc -l <<< "$(echo "$(ps -u $username)")")
            echo "$username: $enaka $obstaja $(expr $groups - 2) $(expr $processes - 1)"
        else
            echo "$username: err"
        fi
    done
    exit 0
}

function tocke() {
    st_studentov=0
    skupaj_tocke=0
    while read LINE; do
        if [ "${LINE:0:1}" = "#" ]; then
            continue;
        fi

        st_studentov=$(expr $st_studentov + 1)

        array=($LINE)

        vpisna=${array[0]} 
        a=${array[1]} 
        b=${array[2]} 
        c=${array[3]}
        tip=${array[4]}

        tocke=$(expr $a + $b + $c)

        prepolovi=false
        [ "$tip" = "p" ] || [ "$tip" = "P" ] && prepolovi=true

        enaka_14=false
        [ "${vpisna:2:2}" = "14" ] && ! $prepolovi && enaka_14=true

        if $prepolovi; then
            tocke=$(expr $tocke / 2)
        elif $enaka_14; then
            random_value=$(($RANDOM % 5 + 1))
            tocke=$(expr $tocke + $random_value)
        fi

        [[ $tocke -gt 50 ]] && tocke=50

        skupaj_tocke=$(expr $skupaj_tocke + $tocke)
        echo "$vpisna: $tocke"
    done

    echo "St. studentov: $st_studentov"
    echo "Povprecne tocke: $(expr $skupaj_tocke / $st_studentov)"
    exit 0
}

function drevo() {
    local max_globina=$2
    local globina=$3
    local is_start=false
    [ -z "$max_globina" ] && max_globina=3
    if [ -z "$globina" ]; then
        printf "%-5s %s\n" "DIR" "$1"
        globina=1
        is_start=true
    fi 

    if [[ $globina -le $max_globina ]]; then
        for FILE in "$1"/*; do 
            output_name=$(echo $FILE | cut -c$(expr ${#1} + 2)-${#FILE})
            file_type=$(ls -l "$FILE" | head -c 1 )
            [ -d "$FILE" ] && file_type=d

            for (( i = 1; i <= $globina; i++ )); do
                printf '%s' "----"
            done

            case $file_type in 
                "-") file_type="FILE" ;;
                "d") file_type="DIR" ;;
                "c") file_type="CHAR" ;;
                "b") file_type="BLOCK" ;;
                "s") file_type="SOCK" ;;
                "p") file_type="PIPE" ;;
                "l") file_type="LINK" ;;
            esac

            printf "%-5s %s\n" "$file_type" "$output_name"

            [ $file_type = "DIR" ] && ! [ -z "$(ls -A $FILE)" ] && drevo $FILE $max_globina $(expr $globina + 1)
        done
    fi

    if $is_start; then
        exit 0
    fi
}

function prostor() {
    local max_globina=$2
    local globina=$3
    local is_start=false

    [ -z "$max_globina" ] && max_globina=3
    if [ -z "$globina" ]; then
        globina=1
        is_start=true

        velikosti=$(stat --printf="%s" $1)
        blokov=$(stat --printf="%b" $1)
    fi 

    if [[ $globina -le $max_globina ]]; then
        for FILE in $1/*; do 
            output_name=$(echo $FILE | cut -c$(expr ${#1} + 2)-${#FILE})
            is_dir=false
            [ -d "$FILE" ] && is_dir=true

            local v=$(stat --printf="%s" $FILE)
            local b=$(stat --printf="%b" $FILE)

            velikosti=$(expr $velikosti + $v)
            blokov=$(expr $blokov + $b)

            $is_dir && ! [ -z "$(ls -A $FILE)" ] && prostor $FILE $max_globina $(expr $globina + 1)
        done
    fi

    if $is_start; then
        echo "Velikost: $velikosti"
        echo "Blokov: $blokov"
        echo "Prostor: $(( $blokov * 512 ))"
        exit 0
    fi
}

function false_action() {
    echo "Napacna uporaba skripte!"
    pomoc
    exit 42
}

case $1 in
    "pomoc") pomoc ;;
    "hehho") hehho "$@" ;;
    "status") status "$@" ;;
    "leto") leto "${@:2}" ;;
    "stej") stej "${@:2}" ;;
    "fib") fib "${@:2}" ;;
    "upori") upori "${@:2}" ;;
    "tocke") tocke "$@" ;;
    "drevo") drevo $2 $3 ;;
    "prostor") prostor $2 $3 ;;
    *) false_action ;;
esac
```