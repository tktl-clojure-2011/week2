(ns week2.test-recursion
  (:use week2.recursion
        midje.sweet))

(facts "product"
       (product [])        => 1
       (product [1 2 3])   => 6
       (product [1 2 3 4]) => 24
       (product [0 1 2])   => 0
       (product #{2 3 4})  => 24)

(facts "last-element"
       (last-element [])      => nil
       (last-element [1 2 3]) => 3
       (last-element [2 5])   => 5)

(facts "sequence-contains?"
       (sequence-contains? 3 [1 2 3]) => true
       (sequence-contains? 3 [4 7 9]) => false
       (sequence-contains? :pony [])  => false)

(facts "seq="
       (seq= [1 2 4] '(1 2 4))  => true
       (seq= [1 2 3] [1 2 3 4]) => false
       (seq= [1 3 5] [])        => false)

(facts "power"
       (power 2 2)  => 4
       (power 5 3)  => 125
       (power 7 0)  => 1
       (power 0 10) => 0)

(facts "fib"
       (fib 0) => 0
       (fib 1) => 1
       (fib 2) => 1
       (fib 3) => 2
       (fib 4) => 3
       (fib 5) => 5
       (fib 6) => 8
       (fib 10) => 55)

(facts "my-range"
       (my-range 0)  => nil
       (my-range 1)  => [0]
       (my-range 2)  => [1 0]
       (my-range 3)  => [2 1 0])

(facts "map-1"
       (map-1 identity [])                 => empty?
       (map-1 identity [1 2 3])            => [1 2 3]
       (map-1 count ["aaa" "bb" "cccc"])   => [3 2 4]
       (map-1 first [[1 2] [4] [7 12 28]]) => [1 4 7]
       (map-1 zero? [0 2 0 13 4 0])
           => [true false true false false true])

(facts "tails"
       (tails [1 2 3 4])   => (just [[1 2 3 4] [2 3 4] [3 4] [4] empty?] :in-any-order)
       (tails [])          => (just [empty?] :in-any-order)
       (tails [1])         => (just [[1] empty?] :in-any-order))

(facts "inits"
       (inits [1 2 3 4])   => (just [empty? [1] [1 2] [1 2 3] [1 2 3 4]] :in-any-order)
       (inits [])          => (just [empty?] :in-any-order)
       (inits [1])         => (just [empty? [1]] :in-any-order))

(facts "split-into-monotonics"
       (split-into-monotonics [0 1 2 1 0])   => '((0 1 2) (1 0))
       (split-into-monotonics [0 5 4 7 1 3]) => '((0 5) (4 7) (1 3)))
