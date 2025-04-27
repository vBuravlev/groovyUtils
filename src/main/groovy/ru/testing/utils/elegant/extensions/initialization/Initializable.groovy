package ru.testing.utils.elegant.extensions.initialization

/**
 * You need to add an annotation for the heir
 * @InheritConstructors
 */
class Initializable {

    Initializable() {}
    Initializable(Closure initClosure) {
        initClosure.delegate = this
        initClosure.resolveStrategy = Closure.DELEGATE_FIRST
        initClosure()
    }
}
