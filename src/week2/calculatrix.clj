(ns week2.calculatrix)

(defn read-words []
  "Read a line and split it into words. Returns the words as a vector
  of strings."
  (let [line (read-line)]
    (vec (.split line " "))))

(defn string->number [string]
  (try
    (Integer/parseInt string)
    (catch NumberFormatException e nil)))

(defn compute [command args]
  "Takes a command and a sequence of arguments, returns computed value
  or nil if given an unknown command or non-integer operands."
  (let [first-operand (string->number (first args))
        second-operand (string->number (second args))]
    (when (and first-operand second-operand)
      (case command
        "+" (+ first-operand second-operand)
        "*" (* first-operand second-operand)))))

(defn main []
  "This is the driver loop of the calculator. It loops by calling itself recursively."
  (let [words (read-words)
        command (first words)
        arguments (rest words)
        result (compute command arguments)]
    (println "  =>" result))
  (main))
