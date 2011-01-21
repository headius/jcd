package org.jruby.jcd;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyConstant;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;

public class Dispatch {
    public static void initDispatch(Ruby ruby) {
        RubyModule mDispatch = ruby.defineModule("Dispatch");
        mDispatch.defineAnnotatedConstants(Dispatch.class);

        RubyClass cObject = mDispatch.defineClassUnder("Object", ruby.getObject(), DispatchObject.ALLOCATOR);
        cObject.defineAnnotatedMethods(DispatchObject.class);

        RubyClass cQueue = mDispatch.defineClassUnder("Queue", cObject, DispatchQueue.ALLOCATOR);
        cQueue.defineAnnotatedMethods(DispatchQueue.class);

        RubyClass cGroup = mDispatch.defineClassUnder("Group", cObject, DispatchGroup.ALLOCATOR);
        cGroup.defineAnnotatedMethods(DispatchGroup.class);

        RubyClass cSource = mDispatch.defineClassUnder("Source", cObject, DispatchSource.ALLOCATOR);
        cSource.defineAnnotatedMethods(DispatchSource.class);
        cSource.defineAnnotatedConstants(DispatchSource.class);

        RubyClass cSemaphore = mDispatch.defineClassUnder("Semaphore", cObject, DispatchSemaphore.ALLOCATOR);
        cSemaphore.defineAnnotatedMethods(DispatchSemaphore.class);
    }

    @JRubyConstant public static final int TIME_NOW = 0;
    @JRubyConstant public static final int TIME_FOREVER = 0;

    public static class DispatchObject extends RubyObject {
        public static final ObjectAllocator ALLOCATOR = new ObjectAllocator() {
            public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
                return new DispatchObject(runtime, klazz);
            }
        };

        public DispatchObject(Ruby runtime, RubyClass klazz) {
            super(runtime, klazz);
        }

        @JRubyMethod(name = "resume!")
        public IRubyObject resume_bang() {
            return this;
        }

        @JRubyMethod(name = "suspend!")
        public IRubyObject suspend_bang() {
            return this;
        }

        @JRubyMethod(name = "suspended?")
        public IRubyObject suspended_p() {
            return this;
        }
    }

    public static class DispatchQueue extends DispatchObject {
        public static final ObjectAllocator ALLOCATOR = new ObjectAllocator() {
            public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
                return new DispatchQueue(runtime, klazz);
            }
        };

        public DispatchQueue(Ruby runtime, RubyClass klazz) {
            super(runtime, klazz);
        }
        
        @JRubyMethod(meta = true)
        public static IRubyObject alloc(IRubyObject self) {
            return self;
        }
        
        @JRubyMethod(meta = true, rest = true)
        public static IRubyObject concurrent(IRubyObject self, IRubyObject[] args) {
            return self;
        }
        
        @JRubyMethod
        public IRubyObject current() {
            return this;
        }
        
        @JRubyMethod
        public IRubyObject main() {
            return this;
        }
        
        @JRubyMethod
        public IRubyObject initialize(IRubyObject arg) {
            return this;
        }

        @JRubyMethod
        public IRubyObject apply(IRubyObject arg) {
            return this;
        }

        @JRubyMethod(rest = true)
        public IRubyObject async(IRubyObject[] args) {
            return this;
        }

        @JRubyMethod
        public IRubyObject sync() {
            return this;
        }

        @JRubyMethod
        public IRubyObject after(IRubyObject arg) {
            return this;
        }

        @JRubyMethod
        @Deprecated
        public IRubyObject label() {
            return this;
        }

        @JRubyMethod
        public IRubyObject to_s() {
            return this;
        }
        
        /*
         rb_queue_finalize_super = rb_objc_install_method2((Class)cQueue,
	    "finalize", (IMP)rb_queue_finalize);

    qHighPriority = rb_queue_from_dispatch(dispatch_get_global_queue(
		DISPATCH_QUEUE_PRIORITY_HIGH, 0), true);
    qDefaultPriority = rb_queue_from_dispatch(dispatch_get_global_queue(
		DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), true);
    qLowPriority = rb_queue_from_dispatch(dispatch_get_global_queue(
		DISPATCH_QUEUE_PRIORITY_LOW, 0), true);

    qMain = rb_queue_from_dispatch(dispatch_get_main_queue(), true);
    rb_objc_define_method(rb_singleton_class(qMain), "run", rb_main_queue_run,
	    0);
         */
    }

    public static class DispatchGroup extends DispatchObject {
        public static final ObjectAllocator ALLOCATOR = new ObjectAllocator() {
            public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
                return new DispatchGroup(runtime, klazz);
            }
        };

        public DispatchGroup(Ruby runtime, RubyClass klazz) {
            super(runtime, klazz);
        }

        @JRubyMethod(meta = true)
        public static IRubyObject alloc(IRubyObject self) {
            return self;
        }

        @JRubyMethod
        public IRubyObject initialize() {
            return this;
        }

        @JRubyMethod
        public IRubyObject notify(IRubyObject arg) {
            return this;
        }

        @JRubyMethod
        public IRubyObject on_completion(IRubyObject arg) {
            return this;
        }

        @JRubyMethod(rest = true)
        public IRubyObject wait(IRubyObject[] args) {
            return this;
        }

        /*
    rb_group_finalize_super = rb_objc_install_method2((Class)cGroup,
	    "finalize", (IMP)rb_group_finalize);
         */
    }

    public static class DispatchSource extends DispatchObject {
        public static final ObjectAllocator ALLOCATOR = new ObjectAllocator() {
            public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
                return new DispatchSource(runtime, klazz);
            }
        };

        public DispatchSource(Ruby runtime, RubyClass klazz) {
            super(runtime, klazz);
        }

        @JRubyConstant public static final int DATA_ADD         = 0;
        @JRubyConstant public static final int DATA_OR          = 0;
        @JRubyConstant public static final int PROC             = 0;
        @JRubyConstant public static final int READ             = 0;
        @JRubyConstant public static final int SIGNAL           = 0;
        @JRubyConstant public static final int VNODE            = 0;
        @JRubyConstant public static final int WRITE            = 0;

        @JRubyConstant public static final int PROC_EXIT        = 0;
        @JRubyConstant public static final int PROC_FORK        = 0;
        @JRubyConstant public static final int PROC_EXEC        = 0;
        @JRubyConstant public static final int PROC_SIGNAL      = 0;

        @JRubyConstant public static final int VNODE_DELETE     = 0;
        @JRubyConstant public static final int VNODE_WRITE      = 0;
        @JRubyConstant public static final int VNODE_EXTEND     = 0;
        @JRubyConstant public static final int VNODE_ATTRIB     = 0;
        @JRubyConstant public static final int VNODE_LINK       = 0;
        @JRubyConstant public static final int VNODE_RENAME     = 0;
        @JRubyConstant public static final int VNODE_REVOKE     = 0;

        @JRubyMethod(meta = true)
        public static IRubyObject alloc(IRubyObject self) {
            return self;
        }

        @JRubyMethod(meta = true, required = 4)
        public static IRubyObject timer(IRubyObject self, IRubyObject[] args) {
            return self;
        }

        @JRubyMethod(required = 4)
        public IRubyObject initialize(IRubyObject[] args) {
            return this;
        }

        @JRubyMethod(name = "cancelled?")
        public IRubyObject cancelled_p() {
            return this;
        }

        @JRubyMethod(name = "cancel!")
        public IRubyObject cancel_bang() {
            return this;
        }

        @JRubyMethod
        public IRubyObject handle() {
            return this;
        }

        @JRubyMethod
        public IRubyObject mask() {
            return this;
        }

        @JRubyMethod
        public IRubyObject data() {
            return this;
        }

        @JRubyMethod(name = "<<")
        public IRubyObject op_lt(IRubyObject arg) {
            return this;
        }

        /*
    rb_source_finalize_super = rb_objc_install_method2((Class)cSource,
	    "finalize", (IMP)rb_source_finalize);
         */
    }

    public static class DispatchSemaphore extends DispatchObject {
        public static final ObjectAllocator ALLOCATOR = new ObjectAllocator() {
            public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
                return new DispatchSemaphore(runtime, klazz);
            }
        };

        public DispatchSemaphore(Ruby runtime, RubyClass klazz) {
            super(runtime, klazz);
        }

        @JRubyMethod(meta = true)
        public static IRubyObject alloc(IRubyObject self) {
            return self;
        }

        @JRubyMethod
        public IRubyObject initialize(IRubyObject arg) {
            return this;
        }

        @JRubyMethod(rest = true)
        public IRubyObject wait(IRubyObject[] args) {
            return this;
        }

        @JRubyMethod
        public IRubyObject signal() {
            return this;
        }

        /*
    rb_semaphore_finalize_super = rb_objc_install_method2((Class)cSemaphore,
	    "finalize", (IMP)rb_semaphore_finalize);
         */
    }
}
