	.arch armv7-a
	.eabi_attribute 27, 3
	.eabi_attribute 28, 1
	.fpu neon
	.eabi_attribute 20, 1
	.eabi_attribute 21, 1
	.eabi_attribute 23, 3
	.eabi_attribute 24, 1
	.eabi_attribute 25, 1
	.eabi_attribute 26, 2
	.eabi_attribute 30, 6
	.eabi_attribute 34, 1
	.eabi_attribute 18, 4
	.file	"code.c"
	.global	accum
	.bss
	.align	2
	.type	accum, %object
	.size	accum, 4
accum:
	.space	4
	.text
	.align	2
	.global	sum
	.type	sum, %function
sum:
	@ args = 0, pretend = 0, frame = 16
	@ frame_needed = 1, uses_anonymous_args = 0
	@ link register save eliminated.
	str	fp, [sp, #-4]!
	add	fp, sp, #0
	sub	sp, sp, #20
	str	r0, [fp, #-16]
	str	r1, [fp, #-20]
	ldr	r2, [fp, #-16]
	ldr	r3, [fp, #-20]
	add	r3, r2, r3
	str	r3, [fp, #-8]
	ldr	r3, .L3
.LPIC0:
	add	r3, pc, r3
	ldr	r2, [r3]
	ldr	r3, [fp, #-8]
	add	r2, r2, r3
	ldr	r3, .L3+4
.LPIC1:
	add	r3, pc, r3
	str	r2, [r3]
	ldr	r3, [fp, #-8]
	mov	r0, r3
	sub	sp, fp, #0
	@ sp needed
	ldr	fp, [sp], #4
	bx	lr
.L4:
	.align	2
.L3:
	.word	accum-(.LPIC0+8)
	.word	accum-(.LPIC1+8)
	.size	sum, .-sum
	.ident	"GCC: (GNU) 4.9.3"
	.section	.note.GNU-stack,"",%progbits
